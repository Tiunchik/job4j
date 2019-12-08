/**
 * Учебный одномерный массив типа integer
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.array;

/**
 * Массив, в котором все переменные взведены в квадрат
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @since 07.12.2019
 * @version 0.2
 */
public class Square {

    /**
     * Метод для заполнения массива int, все переменные массива последовательно
     * заполняються числами от 1 до bound в квадрате
     * @param bound переменная определяет размер массива, который нужно заполнить
     * @return возвращает однолинейный массив для заполнения другого массива
     */
    public int[] fullFillInt(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i < (bound + 1); i++) {
            rst[i - 1] = i * i;
        }
        return rst;
    }
}