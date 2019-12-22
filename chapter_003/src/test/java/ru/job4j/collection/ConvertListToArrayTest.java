/**
 * Пакет для работы с коллекциями ArrayList/LinkedList
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс ConvertListToArrayTest - содержит методы по авоттестированию метода ConvertListToArray -
 * превращение линейеного массива в двумерный массив
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 22.12.2019
 */
public class ConvertListToArrayTest {
    /**
     * Автоматический тест метод метода ConvertListToArray
     */
    @Test
    public void when7ElementsThen9() {
        ConvertListToArray list = new ConvertListToArray();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }
    /**
     * Автоматический тест метод метода ConvertListToArray
     */
    @Test
    public void when11ElementsThen12() {
        ConvertListToArray list = new ConvertListToArray();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
                4
        );
        int[][] expect = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 0}
        };
        assertThat(result, is(expect));
    }
}
