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
public class ControllQuality {
    private static final Logger LOG = LogManager.getLogger(ControllQuality.class.getName());

    private Set<Storage> listStorage;

    ControllQuality(Set<Storage> listStorage) {
        this.listStorage = listStorage;
    }


    /**
     * Collect all Food from all Storages
     *
     * @return List of Food from all storages
     */
    public List<Food> prepareList() {
        List<Food> answer = new ArrayList<>();
        for (var e : listStorage) {
            while (e.hasNext()) {
                answer.add(e.get());
            }
        }
        return answer;
    }

    /**
     * add food to set of storages accordingly accept method of storage
     *
     * @param e food true if
     */
    public void add(Food e) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date today = cal.getTime();
        double check = ((double) (e.getCreatedDate().getTime() - today.getTime()))
                / ((double) (e.getCreatedDate().getTime() - e.getExpairedDate().getTime()));
        for (var str : listStorage) {
            if (str.accept(check)) {
                if (check > 0.75 && check < 1.0) {
                    e.setDisscount(check);
                }
                str.push(e);
            }
        }
    }

    public void addAll(List<Food> list) {
        for (var e : list) {
            add(e);
        }
    }

    /**
     * Resort List of Food to defferent Storages
     */
    public void resort() {
        List<Food> tempList = prepareList();
        addAll(tempList);
    }
}
