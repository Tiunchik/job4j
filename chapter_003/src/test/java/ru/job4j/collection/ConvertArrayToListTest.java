/**
 * Пакет для тестов классов содержащихся в пакете ru.job4j.collection
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс ConvertArrayToListTest - класс содержит автоматические методы для проверки работы класса ConvertArrayToList,
 * тесты предоставлены Petr Arsentev (job4j.ru)
 *
 * @author -
 * @version 0.1
 * @since 22.12.2019
 */
public class ConvertArrayToListTest {

    @Test
    public void when2on2ArrayThenList4() {
        ConvertArrayToList list = new ConvertArrayToList();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = List.of(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when3on3ArrayThenList9() {
        ConvertArrayToList list = new ConvertArrayToList();
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        List<Integer> expect = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}
