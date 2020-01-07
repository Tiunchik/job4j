/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс SimpleSetListTest - набор тестов для класса SimpleSetList
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.01.2019
 */
public class SimpleSetListTest {

    public SimpleSetList<String> base = new SimpleSetList<>();

    @Before
    public void setUp() throws Exception {
        base.add("one");
        base.add("two");
        base.add("three");
        base.add("four");
    }

    @Test
    public void add() {
        base.add("five");
        base.add("five");
        var iter = base.iterator();
        StringBuilder answer = new StringBuilder();
        while (iter.hasNext()) {
            answer.append(iter.next());
        }
        String expected = "onetwothreefourfive";
        assertEquals(expected, answer.toString());
    }

    @Test (expected = ConcurrentModificationException.class)
    public void iterator() {
        var iter = base.iterator();
        iter.next();
        base.add("five");
        iter.next();
    }

    @Test
    public void size() {
        assertTrue(base.size() == 4);
    }
}