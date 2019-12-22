/**
 * Пакет для работы/учёбы с коллекциями.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import java.util.ArrayList;

/**
 * Класс UserArrayList - класс для начала работы с коллекцией ArrayList
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 22.12.2019
 */
public class UsageArrayList {
    /**
     * метод main
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        ArrayList<String> base = new ArrayList<String>();
        base.add("Petr");
        base.add("Maks");
        base.add("Andrey");
        for (String show : base) {
            System.out.println(show);
        }
    }
}
