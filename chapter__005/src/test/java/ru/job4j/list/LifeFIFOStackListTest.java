/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Класс LifeFIFOStackListTest - набор тестов для класса LifeFIFOStackList
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.01.2019
 */
public class LifeFIFOStackListTest {

    LifeFIFOStackList<String> base = new LifeFIFOStackList<>();

    @Before
    public void setUp() throws Exception {
        base.push("one");
        base.push("two");
        base.push("three");
    }

    @Test
    public void whenUsePoll() {
       assertEquals("one", base.poll());
       assertEquals("two", base.poll());
       base.push("four");
       assertEquals("three", base.poll());
    }

    @Test
    public void whenfirstUsePush() {
        base.push("four");
        base.push("five");
        assertEquals("one", base.poll());
    }

    @Test
    public void whenBaseIsEmpty() {
        base.poll();
        base.poll();
        base.poll();
        assertNull(base.poll());
    }
}