/**
 * Тестовое задание по созданию компаратора для объекта Item
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import java.util.Comparator;
/**
 * Класс SortTrackerDown - используется для сортировки объектов Item по полю name по убыванию
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 23.12.2019
 */
public class SortTrackerDown implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return second.compareTo(first);
    }
}
