/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Класс SimpleMapTest -набор тестов для SimpleMap
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 09.01.2019
 */
public class SimpleMapTest {

    SimpleMap<String, Integer> base = new SimpleMap<>();

    @Before
    public void setUp() throws Exception {
        assertTrue(base.insert("Petr", 1));
    }

    @Test
    public void whenWeTryInsertTheSameObject() {
        assertFalse(base.insert("Petr", 1));
    }

    @Test
    public void whenWeTrToGetFirstObject() {
        assertEquals(1, (int) base.get("Petr"));
    }

    @Test
    public void whenWeDeleteAndTryFind() {
        assertTrue(base.delete("Petr"));
        assertNull(base.get("Petr"));
    }

    @Test //Не корректный тест, но пока не понимаю в чём ошибка приведения
    public void whenWetrToFindKeyArray() {
        assertTrue(base.insert("Maksim", 1));
        Object[] answer = base.keySet();
        assertEquals(2, answer.length);
        assertEquals(2, base.size());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iterator() {
        Iterator temp = base.iterator();
        assertTrue(base.insert("Maksim", 1));
        temp.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenTestIterator() {
        Iterator temp = base.iterator();
        temp.next();
        assertFalse(temp.hasNext());
        temp.next();
    }

    @Test
    public void whenchangePersent() {
        base.setPersent(0.99);
        assertEquals(0.99, base.getPersent(), 0.01);
    }
}