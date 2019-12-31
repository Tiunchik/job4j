/**
 * Пакет для работы/учёбы с коллекциями.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.search;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс FullSearchTest - класс для тестирования методов класса FullSearch
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 31.12.2019
 */
public class FullSearchTest {
    /**
     * Тест метода extractNumber
     */
    @Test
    public void extractNumber() {
        List<Task> tasks = List.of(
                new Task("First desc", 1),
                new Task("Second desc", 2),
                new Task("First desc", 1)
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(FullSearch.extractNumber(tasks), is(expected));
    }
}