/**
 * Тест для учебного одномерный массива типа integer по поиску значения и возвращния его индекса
 * @author Petr Arsentev
 */
package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Автоматический тест для массива, в котором производится поиск значения
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
        int[] input = new int[] {5, 10, 3};
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
        int[] input = new int[] {5, 10, 3, 15, 6};
        int value = 26;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}