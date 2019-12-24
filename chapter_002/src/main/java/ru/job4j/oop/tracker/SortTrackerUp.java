/**
 * Тестовое задание по созданию компаратора для объекта Item
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import java.util.Comparator;
/**
 * Класс SortTrackerUp - используется для сортировки объектов Item по полю name по возрастанию
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 23.12.2019
 */
public class SortTrackerUp implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return first.compareTo(second);
    }
}
