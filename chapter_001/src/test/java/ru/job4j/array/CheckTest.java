/**
 * Тест для учебного задания по определению однородности линейного массива типа boolean
 *
 * @author Petr Arsentev
 */
package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс-автоматический тест для задания по определению однородности линейного массива типа boolean
 *
 * @author Petr Arsentev (parsentev@yandex.ru,job4j.ru)
 * @version -
 * @since -
 */
public class CheckTest {
    /**
     * Метод для автоматического теста класса ru.job4j.array.Check для чётного массива
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.Check для чётного массива
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.Check для чётного массива созданый учником
     *
     * @author Maksim Tiunchik
     */
    @Test
    public void studentTestOne() {
        Check check = new Check();
        //boolean[] input = new boolean[]{true, false, true};
        boolean result = check.mono(new boolean[]{false, false, false, false, true});
        assertThat(result, is(false));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.Check для чётного массива созданый учником
     *
     * @author Maksim Tiunchik
     */
    @Test
    public void studentTestTwo() {
        Check check = new Check();
        assertThat(true, is(check.mono(new boolean[]{false, false, false, false, false, false})));
    }
}