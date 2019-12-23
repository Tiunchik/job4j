/**
 * Пакет для работы с коллекцией HashSet
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.order;

import java.util.HashMap;
import java.util.List;

/**
 * Класс OrderConvert - класс для конвертации коллекции Order в коллекцию HashSet.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 22.12.2019
 */
public class OrderConvert {
    /**
     * Метод для конвертации коллекции Order в коллекцию HashSet.
     *
     * @param orders - коллекция List<Order> orders вводимая для доработки
     * @return - коллекция HashMap<String, Order> - доработанная коллекция List<Order> orders
     */
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        int index = 0;
        for (Order x : orders) {
            map.put(index + "", x);
            index++;
        }
        return map;
    }
}