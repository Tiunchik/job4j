/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Класс LifeArrayListTest -набор тестов для LifeArrayList
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 06.01.2019
 */
public class LifeArrayListTest {

    LifeArrayList<String> it;

    @Before
    public void setUp() throws Exception {
        it = new LifeArrayList<>(4);
        it.add("1");
        it.add("2");
        it.add("3");
        it.add("4");
    }

    @Test
    public void add() {
        it.add("5"); //если добавилось 5 значение, значит массив корректно работает
        boolean inf = true;
        assertTrue(inf);
    }

    @Test
    public void get() {
        it.add("5");
        assertEquals(it.get(4), "5");
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iterator() {
        Iterator temp = it.iterator();
        temp.next();
        it.add("5");
        temp.next();
    }
}