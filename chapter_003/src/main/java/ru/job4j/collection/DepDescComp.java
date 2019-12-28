/**
 * Пакет для тестового задания по сортировке и работе со списками "отортровать департаменты"
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import java.util.Comparator;

/**
 * Класс DepDescComp - компоратор для массива/коллекции типа String в обратном естественному порядке
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 28.12.2019
 */
public class DepDescComp implements Comparator<String> {
    /**
     * Переопределённый метод compare
     *
     * @param o1 - первая переменная для сравнения
     * @param o2 - вторая переменная для сравнения
     * @return возвращает значения обратные значения компоратора NaturalOrdering
     */
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}
