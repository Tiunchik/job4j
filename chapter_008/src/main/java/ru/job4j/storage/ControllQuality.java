/**
 * Пакет ru.job4j.storage для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Класс ControllQuality - sort Food between storages: shop warehouse, trash
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.02.2020
 */
public class ControllQuality<T extends Food> {
    private static final Logger LOG = LogManager.getLogger(ControllQuality.class.getName());
    /**
     * innet queue for sorting
     */
    private LinkedList<T> innerList = new LinkedList<>();

    /**
     * sort Food between storages
     *
     * @param shop Fresh food will be keep here
     * @param warehouse Food with expaire term between 75% and 0% wll be stored here
     * @param trash Spoiled food will be stored here
     */
    public void sort(Storage<T> shop, Storage<T> warehouse, Storage<T> trash) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        String key = "";
        Date today = cal.getTime();
        Map<String, Storage<T>> changer = new HashMap<>();
        changer.put("shop", shop);
        changer.put("warehouse", warehouse);
        changer.put("trash", trash);
        T temp;
        while (warehouse.hasNext()) {
            temp = warehouse.get();
            innerList.push(temp);
        }
        while (shop.hasNext()) {
            temp = shop.get();
            innerList.push(temp);
        }
        while (!innerList.isEmpty()) {
            temp = innerList.pollFirst();
            double check = ((double) (temp.getCreatedDate().getTime() - today.getTime()))
                    / ((double) (temp.getCreatedDate().getTime() - temp.getExpairedDate().getTime()));
            if (check < 0.25) {
                key = "shop";
            } else if (check < 0.75) {
                key = "shop";
                temp.setDisscount(check);
            } else if (check < 1.00) {
                key = "warehouse";
            } else {
                key = "trash";
            }
            changer.get(key).push(temp);
        }

    }


}
