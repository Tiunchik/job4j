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
 * Класс LifeStackListTest - набор тестов для класса LifeStackList
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 06.01.2019
 */
public class LifeStackListTest {

    LifeStackList<String> base = new LifeStackList<>();

    @Before
    public void setUp() throws Exception {
        base.push("one");
        base.push("two");
        base.push("three");
        base.push("four");
    }

    @Test
    public void poll() {
        assertEquals("four", base.poll());
    }

    @Test
    public void push() {
        assertEquals("four", base.poll());
        base.push("four");
        assertEquals("four", base.poll());
    }
}