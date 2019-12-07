/**
 * Тест для учебного одномерный массива типа integer
 * @author Petr Arsentev
 */
package ru.job4j.array;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Автоматический тест для массива, в котором все переменные взведены в квадрат
 * @author Petr Arsentev (parsentev@yandex.ru,job4j.ru)
 * @since -
 * @version 0.2
 */

public class SquareTest {
    /**
     * Метод для автоматического теста класса ru.job4j.array.Square
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.fullFillInt(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }
    /**
     * Дополнитльный метод для автоматического теста класса ru.job4j.array.Square
     */
    @Test
    public void whenBound4Then14916() {
        int bound = 4;
        Square square = new Square();
        int[] rst = square.fullFillInt(bound);
        int[] expect = new int[] {1, 4, 9, 16};
        assertThat(rst, is(expect));
    }
}