/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.list;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Класс LifeLinkedListTest - набор тестов для класса LifeLinkedList
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 06.01.2019
 */
public class LifeLinkedListTest {

    LifeLinkedList<String> base = new LifeLinkedList<>();


    @Before
    public void setUp() throws Exception {
        base.add("one");
        base.add("two");
        base.add("three");
        base.add("four");

    }

    @Test(expected = NoSuchElementException.class)
    public void whenTestIterator() {
        Iterator temp = base.iterator();
        assertEquals("one", temp.next());
        assertTrue(temp.hasNext());
        assertEquals("two", temp.next());
        assertTrue(temp.hasNext());
        assertEquals("three", temp.next());
        assertTrue(temp.hasNext());
        assertEquals("four", temp.next());
        assertFalse(temp.hasNext());
        temp.next();
    }

    @Test
    public void whenTestGet() {
        assertEquals("two", base.get(1));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whentestDelete() {
        base.delete();
        Iterator temp = base.iterator();
        assertEquals("two", temp.next());
        base.delete();
        temp.next();
    }

    @Test
    public void name() {
        LifeLinkedList<Integer> base = new LifeLinkedList<>();
        base.add(1);
        base.add(2);
        base.delete();
        Assert.assertThat(base.get(0), Is.is(2));
    }
}