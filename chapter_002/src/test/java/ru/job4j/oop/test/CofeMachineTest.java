/**
 * Тестовое задание по работе с жадным алгоритмом
 *
 * @author -
 */
package ru.job4j.oop.test;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Класс CofeMachineTest - набор автоматических тестов для класса CofeMachine
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 22.12.2019
 */
public class CofeMachineTest {
    @Test
    public void whenEquals() {
        CofeMachine machine = new CofeMachine();
        int[] expected = {};
        int[] rsl = machine.change(100, 100);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when50by35() {
        CofeMachine machine = new CofeMachine();
        int[] expected = {10, 5};
        int[] rsl = machine.change(50, 35);
        assertThat(rsl, is(expected));
    }
}
