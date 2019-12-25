/**
 * Тест для учебного задания по сортеровке массива методом выборки
 *
 * @author Petr Arsentev
 */

package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Автоматический тест для массива, в котором производится сортировка методом выборки
 *
 * @author Petr Arsentev (parsentev@yandex.ru,job4j.ru)
 * @version -
 * @since -
 */
public class SortSelectedTest {

    /**
     * Метод для автоматического теста класса ru.job4j.array.SortSelected
     */
    @Test
    public void whenSort() {
        int[] input = new int[]{3, 4, 1, 2, 5};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[]{1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    /**
     * Метод для автоматического теста класса ru.job4j.array.SortSelected
     *
     * @author Maksim Tiunchik
     */
    @Test
    public void studentTestOne() {
        int[] input = new int[]{3, 4, 1, 2, 5, 7, 9, 11, 13, 10, 1};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[]{1, 1, 2, 3, 4, 5, 7, 9, 10, 11, 13};
        assertThat(result, is(expect));
    }
}