/**
 * Тест для учебного задания по переварачиванию массива
 * @author Petr Arsentev
 */
package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Автоматический тест для массива, в котором производится "отзеркаливание"
 * @author Petr Arsentev (parsentev@yandex.ru,job4j.ru)
 * @since -
 * @version -
 */
public class TurnTest {
    /**
     * Метод для автоматического теста класса ru.job4j.array.Turn для чётного массива
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = turner.back(input);
        int[] expect = new int[] {2, 6, 1, 4};
        assertThat(result, is(expect));
    }
    /**
     * Метод для автоматического теста класса ru.job4j.array.Turn для нечетного массива
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        assertThat(turner.back(new int[] {4, 1, 6, 2, 9, 7, 6}), is(new int[] {6, 7, 9, 2, 6, 1, 4}));
        /*Turn turner = new Turn();
        int[] input = new int[] {4, 1, 6, 2, 9, 7, 6};
        int[] result = turner.back(input);
        int[] expect = new int[] {6, 7, 9, 2, 6, 1, 4};
        assertThat(result, is(expect));*/
    }
}