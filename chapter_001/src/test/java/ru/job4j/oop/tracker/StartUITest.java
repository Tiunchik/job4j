/**
 * Тестовое задание по организации теста метода класса StarttUI посредством автоматизированного интерфейса ввода данных
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Класс StabUITest - класс организации автоматизированного теста методов класса StarttUI
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 15.12.2019
 */
public class StartUITest {
    /**
     * Автоматический тест метода StartUI.addItem;
     */
    @Test
    public void whenAddItem() {
        String[] answers = {"Develop code"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.addItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Develop code");
        assertThat(created.getName(), is(expected.getName()));
    }
}
