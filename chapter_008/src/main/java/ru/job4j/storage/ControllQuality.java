/**
 * Пакет ru.job4j.storage для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс ControllQuality - sort Food between storages: shop warehouse, trash
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 21.02.2020
 */
public class ControllQuality<T extends Food> {
    private static final Logger LOG = LogManager.getLogger(ControllQuality.class.getName());

    /**
     * Collect all Food from all Storages
     *
     * @param set Set of storages
     * @return List of Food
     */
    public List<Food> prepareList(Set<Storage> set) {
        List<Food> answer = new ArrayList<>();
        for (var e : set) {
            while (e.hasNext()) {
                answer.add(e.get());
            }
        }
        return answer;
    }


    /**
     * Sort List of Food to defferent Storages
     *
     * @param listStorage List of actions for saving to storages with additional actions
     * @param foodList    List of Food
     */
    public void sort(Map<Double, TakeAction> listStorage, List<Food> foodList) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date today = cal.getTime();
        List<Double> keys = listStorage.keySet().stream().sorted().collect(Collectors.toList());
        for (var e : foodList) {
            double check = ((double) (e.getCreatedDate().getTime() - today.getTime()))
                    / ((double) (e.getCreatedDate().getTime() - e.getExpairedDate().getTime()));
            for (var index : keys) {
                if (check < index) {
                    listStorage.get(index).execute(e);
                    break;
                }
            }
        }
    }

    /**
     * Resort List of Food to defferent Storages
     *
     * @param listStorage List of actions for saving to storages with additional actions
     * @param set         Set of storages
     */
    public void resort(Map<Double, TakeAction> listStorage, Set<Storage> set) {
        List<Food> tempList = prepareList(set);
        sort(listStorage, tempList);
    }
}
