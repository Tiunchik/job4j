/**
 * Учебное задание по переварачиванию массива
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.array;

/**
 * Класс для осуществелния переворачивания массива
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 08.12.2019
 */
public class Turn {
    /**
     * Данные метод переворачивает массив
     *
     * @param array -переменная массив, который необходимо "отзеркалить"
     * @return возвращаемое значение - "отзеркаленны1" массив
     */
    public int[] back(int[] array) {
        int tmp = 0;
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            tmp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = tmp;
        }
        return array;
    }
}

