/**
 * Учебное задание по формированию матрицы с таблицей умножения
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.array;

/**
 * Класс для метода по формированию матрицы с таблицей умножения
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 08.12.2019
 */
public class Matrix {
    /**
     * Метод для формиования матрицы, заполенной значениями таблицы умножеия
     *
     * @param size
     * @return
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                table[i][j] = (i+1)*(j+1);
            }
        }
        return table;
    }
}
