/**
 * Пакет для работы/учёбы с коллекциями.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс UniqueTextTest - класс содержит тесты для методов класса UniqueText
 *
 * @author -
 * @version 0.1
 * @since 31.12.2019
 */
public class UniqueTextTest {
    /**
     * Метод когда значения идентичн
     */
    @Test
    public void isEquals() {
        String origin = "My cat eats a mouse";
        String text = "My cat eats a mouse";
        assertThat(UniqueText.isEquals(origin, text), is(true));
    }
    /**
     * Метод когда значения разные
     */
    @Test
    public void isNotEquals() {
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        assertThat(UniqueText.isEquals(origin, text), is(false));
    }
}