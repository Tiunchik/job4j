/**
 * Учебное задание по сортировке массива методом выборки
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.array;

/**
 * Класс для методов по сортировке массива методом выборки
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 08.12.2019
 */
public class SortSelected {
    /**
     * Метод по сортировке массива методом выборки
     *
     * @param data массив передаваемый на сортировку
     * @return взвращаемый отсортированный массив
     */
    public static int[] sort(int[] data) {
        int temp;
        for (short i = 0; i < data.length; i++) {
            int min = MinDiapason.findMin(data, i, data.length);
            int index = FindLoop.indexOf(data, min, i, data.length);
            temp = data[i];
            data[i] = data[index];
            data[index] = temp;
        }
        return data;
    }
}
