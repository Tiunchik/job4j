/**
 * Тест для учебного задания по поиску минмиального значения в линейном массиве
 *
 * @author Petr Arsentev
 */
package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Автоматический тест для массива, в котором производится поиск минмиального значения
 *
 * @author Petr Arsentev (parsentev@yandex.ru,job4j.ru)
 * @version -
 * @since -
 */
public class MinTest {

    /**
     * Метод для автоматического теста класса ru.job4j.array.Min
     */
    @Test
    public void whenFirstMin() {
        assertThat(
                Min.findMin(
                        new int[]{0, 5, 10}
                ),
                is(0)
        );
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.Min
     */
    @Test
    public void whenLastMin() {
        assertThat(
                Min.findMin(
                        new int[]{10, 5, 3}
                ),
                is(3)
        );
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.Min
     */
    @Test
    public void whenMiddleMin() {
        assertThat(
                Min.findMin(
                        new int[]{10, 2, 5}
                ),
                is(2)
        );
    }
}