/**
 * Пакет для работы с коллекциями ArrayList/LinkedList
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс ConvertArrayToList - содержит метод по преобразованию двумерного массива в линейный
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 22.12.2019
 */
public class ConvertArrayToList {
    /**
     * Метод по преобразованию двумерного массива в линейный
     *
     * @param array - вводимый в метод двумерный массив
     * @return - линейный массив типа list со значениями integer
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<Integer>();
        for (int[] row : array) {
            for (int column : row) {
                list.add(column);
            }
        }
        return list;
    }
}
