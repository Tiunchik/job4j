/**
 * Тест для учебного одномерный массива типа integer по поиску значения и возвращния его индекса
 *
 * @author Petr Arsentev
 */
package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Автоматический тест для массива, в котором производится поиск значения. Как полостью во всём массиве,
 * так и в ограниченном
 *
 * @author Petr Arsentev (parsentev@yandex.ru,job4j.ru)
 * @since -
 * @version -
 */
public class FindLoopTest {

    /**
     * Метод для автоматического теста класса ru.job4j.array.FindLoop
     */
    @Test
    public void whenArrayHas5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.FindLoop
     * @author Maksim Tiunchik
     */
    @Test
    public void whenArrayDoesntHasExpectedNumber() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3, 15, 6};
        int value = 26;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.FindLoop в рамках заданных значений
     */
    @Test
    public void whenArrayHasLength5Then0() {
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = FindLoop.indexOf(input, value, 0, 2); //добавил ограничения в метод, не были внесены
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.FindLoop в рамках заданных значений
     */
    @Test
    public void whenFind3() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.FindLoop в рамках заданных значений,
     * подготовленный учеником
     */
    @Test
    public void studentOneTest() {
        int[] input = new int[]{5, 2, 10, 2, 4, 1, 5, 11, 7, 24, 56 , 7, 9, 5, 4};
        int value = 7;
        int start = 5;
        int finish = 10;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = 8;
        assertThat(result, is(expect));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.FindLoop в рамках заданных значений,
     * подготовленный учеником
     */
    @Test
    public void studentOneTwo() {
        int[] input = new int[]{5, 2, 10, 2, 4, 1, 5, 11, 7, 24, 56 , 7, 9, 5, 4};
        int value = 34;
        int start = 5;
        int finish = 10;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }
}