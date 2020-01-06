/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.list;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Класс SimpleLinkedListTest - класс содержит тесты на класс SimpleLinkedList
 *
 * @author -
 * @version 0.1
 * @since 06.01.2019
 */
public class SimpleLinkedListTest {

    private SimpleLinkedList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    /**
     * Метод добавленный учеником
     * @author Maksim Tiunchik (senebh@gmail.com)
     */
    @Test
    public void whenWeApplyDelete() {
        assertThat(list.delete(), is(3));
        assertThat(list.get(0), is(2));
    }
}