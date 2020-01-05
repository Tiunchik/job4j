/**
 * Пакет для работы с коллекциями/итератором/генериками
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.iterator.generic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Класс SimpleArrayTest - класс для теста методов SimpleArray
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 05.01.2019
 */
public class SimpleArrayTest {
    /**
     * Класс образец по которому проходят тесты
     */
    SimpleArray<String> array;

    /**
     * Формирование значений коллекции до начала тестов
     */
    @Before
    public void setUp() {
        array = new SimpleArray<>(5);
        array.add("space");
        array.add("time");
    }

    /**
     * Тест метода add - применяется в setUp
     */
    @Test
    public void add() {
        var expected = "spacetime";
        assertEquals(expected, array.get(0) + array.get(1));
    }

    /**
     * тест метода set
     */
    @Test
    public void set() {
        array.set(1, null);
        array.set(2, "energy");
        var expected = "spacenullenergy";
        assertEquals(expected, array.get(0) + array.get(1) + array.get(2));
    }

    /**
     * тест метода remove
     */
    @Test
    public void remove() {
        array.remove(0);
        assertEquals(null, array.get(0));
    }

    /**
     * тест метода get
     */
    @Test
    public void get() {
        assertEquals("time", array.get(1));
    }

    /**
     * тест метода iretator
     */
    @Test(expected = NoSuchElementException.class)
    public void iretator() {
        Iterator<String> it = array.iretator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("space"));
        assertThat(it.next(), is("time"));
        it.next();
        it.next();
        it.next();
        it.next();
    }
}