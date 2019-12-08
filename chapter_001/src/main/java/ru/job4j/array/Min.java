/**
 * Учебное задание по поиску значения минимального значения в массиве
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.array;

/**
 * Класс для методов по поиску минимальных значений в массиве
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 08.12.2019
 */

public class Min {

    /**
     * Метод по поиску минимального значений в линейном массиве типа int
     *
     * @param array - массив в котором производится поиск минимального значения
     * @return возвращаемое минмиальное значение из массива array - переменная типа int
     */
    public static int findMin(int[] array) {
        int min = array[0];
        for (int index = 0; index < array.length; index++) {
            if (min > array[index]) {
                min = array[index];
            }
        }
        return min;
    }
}
