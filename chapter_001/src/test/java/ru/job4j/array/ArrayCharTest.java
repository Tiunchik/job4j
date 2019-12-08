/**
 * Тест для учебного задания по сравннию однолинейных массивов типа char
 *
 * @author Petr Arsentev
 */

package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс-автоматический тест для задания по сравннию однолинейных массивов типа char
 *
 * @author Petr Arsentev (parsentev@yandex.ru,job4j.ru)
 * @version -
 * @since -
 */

public class ArrayCharTest {
    /**
     * Метод для автоматического теста класса ru.job4j.array.ArrayChar для разнодлиного массива
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'e'};
        boolean result = ArrayChar.startsWith(word, pref);
        assertThat(result, is(true));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.ArrayChar для разнодлиного массива
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'i'};
        boolean result = ArrayChar.startsWith(word, pref);
        assertThat(result, is(false));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.ArrayChar для однодлинного массива,
     * подготовленный учеником
     *
     * @author Maksim Tiunchik
     */
    @Test
    public void studentTestOne() {
        char[] word = {'S', 't', 'u', 'p', 'i', 'D'};
        char[] pref = {'S', 't', 'u', 'p', 'i', 'D'};
        assertThat(ArrayChar.startsWith(word, pref), is(true));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.ArrayChar для разнодлинного массива,
     * подготовленный учеником
     *
     * @author Maksim Tiunchik
     */
    @Test
    public void studentTestTwo() {
        char[] word = {'S', 't', 'u', 'p', 'i', 'D'};
        char[] pref = {'N', 'o', 't', 'S', 't', 'u', 'p', 'i', 'D'};
        assertThat(ArrayChar.startsWith(word, pref), is(false));
    }
}