/**
 * Тест для учебного задания по поиску ряда одинаковых значений в матрице
 *
 * @author Petr Arsentev
 */


package ru.job4j.array;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Автоматический тест для матрицы, в которой производится поиск ряда одинаковых значений
 *
 * @author Petr Arsentev (parsentev@yandex.ru,job4j.ru)
 * @version -
 * @since -
 */
@Ignore
public class MatrixCheckTest {

    /**
     * Метод для автоматического теста класса ru.job4j.array.MatrixCheck
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(true));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.MatrixCheck
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', 'X', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(false));
    }
}