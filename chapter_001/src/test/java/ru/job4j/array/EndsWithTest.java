/**
 * Тест для учебного задания по эмуляции метода endsWith
 *
 * @author Petr Arsentev
 */

package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Класс-автоматический тест для задания по эмуляции метода endsWith
 *
 * @author Petr Arsentev (parsentev@yandex.ru,job4j.ru)
 * @version -
 * @since -
 */

public class EndsWithTest {
    /**
     * Метод для автоматического теста класса ru.job4j.array.EndsWith для эмуляции метода endsWith
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] post = {'l', 'o'};
        boolean result = EndsWith.endsWith(word, post);
        assertThat(result, is(true));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.EndsWith эмуляции метода endsWith
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] post = {'l', 'a'};
        boolean result = EndsWith.endsWith(word, post);
        assertThat(result, is(false));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.EndsWith эмуляции метода endsWith, внесённый учеником
     *
     * @author Maksim Tiunchik
     */
    @Test
    public void studentTestOne() {
        char[] word = {'1', '0', '0', '0', '1'};
        char[] post = {'1', '0', '0', '0', '1', '1', '1'};
        boolean result = EndsWith.endsWith(word, post);
        assertThat(result, is(false));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.EndsWith эмуляции метода endsWith, внесённый учеником
     *
     * @author Maksim Tiunchik
     */
    @Test
    public void studentTestTwo() {
        char[] word = {'1', '0', '0', '0', '1'};
        char[] post = {'1', '0', '1', '0', '0', '0', '1'};
        boolean result = EndsWith.endsWith(word, post);
        assertThat(result, is(true));
    }
}