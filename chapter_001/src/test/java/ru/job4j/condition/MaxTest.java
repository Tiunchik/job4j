/**
 * Тестовый класс для класса Max - рефакторинг, работа с перегруженными методами.
 * @author Maksim Tiunchik
 */
package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

/**
 * Тестовый класс MaxTest, проверка работы с перегруженными методами.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 11.12.2019
 */
public class MaxTest {
    /**
     * Тест метод для определение корректности работы метода в классе Max
     */
    @Test
    public void secondMore() {
        int i1 = 5;
        int i2 = 18;
        int expected = 18;
        int out = Max.max(i1, i2);
        Assert.assertEquals(expected, out);
    }
    /**
     * Тест метод для определение корректности работы метода в классе Max
     */
    @Test
    public void firstMore() {
        int i1 = 50;
        int i2 = 18;
        int i3 = 24;
        int expected = 50;
        int out = Max.max(i1, i2, i3);
        Assert.assertEquals(expected, out);
    }
    /**
     * Тест метод для определение корректности работы метода в классе Max
     */
    @Test
    public void equalNumbers() {
        int i1 = 25;
        int i2 = 25;
        int i3 = 25;
        int i4 = 26;
        int expected = 26;
        int out = Max.max(i1, i2, i3, i4);
        Assert.assertEquals(expected, out);
    }

}
