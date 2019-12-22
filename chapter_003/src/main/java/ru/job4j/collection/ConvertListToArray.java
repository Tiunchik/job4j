/**
 * Пакет для работы с коллекциями ArrayList/LinkedList
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import java.util.List;

/**
 * Класс ConvertListToArray - нсодержит методы по преобразованию одномерного массива в двухмерный
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 22.12.2019
 */
public class ConvertListToArray {
    /**
     * метод по превращению одномерного массива из коллкеции list (Array, Linked и т.п.) в обычный двумерный массив
     *
     * @param list - массив тпа List
     * @param cells - количество ячеек в первом ряду формируемого двумерного массива
     * @return - заполненный двумерный массив
     */
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {
            if (cell == cells) {
                cell = 0;
                row++;
                if (row == groups) {
                    break;
                }
            }
            array[row][cell++] = num;

        }
        return array;
    }
}
