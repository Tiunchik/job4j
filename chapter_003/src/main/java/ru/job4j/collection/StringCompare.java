/**
 * Пакет для работы с коллекциями ArrayList/LinkedList/HashSet/TreeSet и так же сортировкой компоратором
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import java.util.Comparator;

/**
 * Класс StringCompare используется для создания компаратора для String
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 25.12.2019
 */
public class StringCompare implements Comparator<String> {
    /**
     * Метод compare - реализация метода интерфейса Comparator для объкета типа String
     *
     * @param left  - первая переменная типа string, с котрой сравнивают вторую
     * @param right - вторая переменная типа string, с котрой сравнивают первая
     * @return - возвращаемое значние по итогам сравнния 0 - равны, больше 0 - первая переменная больше второй,
     * меньше 0 - первая переменная меньше второй.
     */
    @Override
    public int compare(String left, String right) {
        char[] charLeft = left.toCharArray(), charRight = right.toCharArray();
        int board = left.length() - right.length() >= 0 ? right.length() : left.length();
        for (int index = 0; index < board; index++) {
            if (Character.compare(charLeft[index], charRight[index]) != 0) {
                return Character.compare(charLeft[index], charRight[index]);
            }
        }
        return left.length() - right.length();
    }
}
