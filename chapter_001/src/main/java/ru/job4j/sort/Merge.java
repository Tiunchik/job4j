/**
 * Тестовое задание по слиянию двух массивов
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.sort;

import java.util.Arrays;

/**
 * Класс для тестового задания по слинию двух разнодлинных массивов
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 09.12.2019
 */

public class Merge {
    /**
     * Метод по слиянию двух массивов в возрастающем порядке
     *
     * @param left  - первый массив передаваемый в метод
     * @param right - второй масив передеваемый в метод
     * @return - возвращаемое значение - новый массив, отсортированный
     */
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int i = 0, j = 0, m = 0;
        while (m < rsl.length) {
            if (i < left.length && j < right.length) {
                if ((left[i] > right[j])) {
                    rsl[m] = right[j++]; // сложно для понимания, порицаемый метод записи?
                    //j++;
                } else {
                    rsl[m] = left[i++];
                    //i++;
                }
            } else {
                if (i < left.length) {
                    rsl[m] = left[i++];
                    //i++;
                } else {
                    rsl[m] = right[j++];
                    //j++;
                }
            }
            m++;
        }
        return rsl;
    }

    /**
     * метод main
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[]{1, 3, 5},
                new int[]{2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
