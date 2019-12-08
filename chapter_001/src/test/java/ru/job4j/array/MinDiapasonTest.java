/**
 * Тест для учебного задания по поиску минмиального значения в линейном массиве int с ограничениями по зоне поиска
 *
 * @author Petr Arsentev
 */
package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Автоматический тест для массива, в котором производится поиск минмиального значения с ограничениями по зоне поиска
 *
 * @author Petr Arsentev (parsentev@yandex.ru,job4j.ru)
 * @version -
 * @since -
 */
public class MinDiapasonTest {

    /**
     * Метод для автоматического теста класса ru.job4j.array.MinDiapason
     */
    @Test
    public void whenFirstMin() {
        assertThat(
                MinDiapason.findMin(
                        new int[] {-1, 0, 5, 10},
                        1, 3
                ),
                is(0)
        );
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.MinDiapason
     */
    @Test
    public void whenLastMin() {
        assertThat(
                MinDiapason.findMin(
                        new int[] {10, 5, 3, 1},
                        1, 3
                ),
                is(3)
        );
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.MinDiapason
     */
    @Test
    public void whenMiddleMin() {
        assertThat(
                MinDiapason.findMin(
                        new int[] {10, 2, 5, 1},
                        0, 2
                ),
                is(2)
        );
    }
}