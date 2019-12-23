/**
 * Пакет для работы с коллекциями ArrayList/LinkedList/HashSet
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import java.util.HashSet;

/**
 * Класс UsageHashSet - содержит метод main по работе с коллекцией HashSet
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 23.12.2019
 */
public class UsageHashSet {

    public static void main(String[] args) {
        HashSet<String> auto = new HashSet<String>();
        auto.add("toyota");
        auto.add("volvo");
        auto.add("bmv");
        auto.add("wv");
        auto.add("reno");
        for (String out : auto) {
            System.out.println(out);
                    }
    }
}
