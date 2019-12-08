/**
 * Тест для учебного задания по формированию матрицы
 *
 * @author Petr Arsentev
 */

package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Автоматический тест для массива, в котором производится формирование матрицы и её заполнения таблицей умножения
 *
 * @author Petr Arsentev (parsentev@yandex.ru,job4j.ru)
 * @version -
 * @since -
 */
public class MatrixTest {

    /**
     * Метод для автоматического теста класса ru.job4j.array.Matrix
     */
    @Test
    public void when2on2() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(2);
        int[][] expect = {
                {1, 2},
                {2, 4}
        };
        assertThat(table, is(expect));
    }
    /**
     * Метод для автоматического теста класса ru.job4j.array.Matrix
     *
     * @author Maksim Tiunchik
     */
    @Test
    public void when3on3() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(3);
        int[][] expect = {
                {1, 2, 3},
                {2, 4, 6},
                {3, 6, 9},
        };
        assertThat(table, is(expect));
    }
}