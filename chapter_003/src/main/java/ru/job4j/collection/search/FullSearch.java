/**
 * Пакет для работы/учёбы с коллекциями.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.search;

import java.util.HashSet;
import java.util.List;

/**
 * Класс FullSearch - класс реализующий метод выборки только индивидальных номеров
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 31.12.2019
 */
public class FullSearch {
    /**
     * метод выборки только индивидальных номеров
     *
     * @param list - список Задач с номерами и описанием
     * @return - список задач где дублруемые номера удалены
     */
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task exp : list) {
            numbers.add(exp.getPriority() + "");
        }
        return numbers;
    }
}
