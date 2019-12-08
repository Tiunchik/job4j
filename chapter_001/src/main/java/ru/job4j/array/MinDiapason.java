/**
 * Учебное задание по поиску значения минимального значения в массиве с ограничением по зоне поиска
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.array;

/**
 * Класс для методов по поиску минимальных значений в массиве с ограничением по зоне поиска
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 08.12.2019
 */
public class MinDiapason {
    /**
     * Метод по поиску значения минимального значения в массиве с ограничением по зоне поиска
     *
     * @param array  - массив в котором прооизводиться поиск минимального значения
     * @param start  - индкес массива с которого нчинается поиск
     * @param finish - индкес массива по который производится поиск (не включителньо)
     * @return - возвращаемое минимальное значение из искомой зоны
     */
    public static int findMin(int[] array, int start, int finish) {
        int min = array[start];
        for (; start < finish; start++) {
            if (min > array[start]) {
                min = array[start];
            }
        }
        return min;
    }
}
