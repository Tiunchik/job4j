/**
 * Пакет для работы/учёбы с коллекциями.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Класс PriorityQueueTest - класс содержит автоматические методы для проверки работы класса PriorityQueue
 * тесты предоставлены Petr Arsentev (job4j.ru)
 *
 * @author -
 * @version 0.2
 * @since 31.12.2019
 */
public class PriorityQueueTest {
    /**
     * Тест функции сортировки в коллекции
     */
    @Test
    public void whenHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        var result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    /**
     * Тест метода take если коллекция пустая
     */
    @Test
    public void whenQueueEmpty() {
        var queue = new PriorityQueue();
        var result = queue.take();
        assertThat(result.getDesc(), is("null"));
    }

    /**
     * Тест ввода в коллекцию одного значения
     */
    @Test
    public void whenQueueWasEmpty() {
        var queue = new PriorityQueue();
        queue.put(new Task("middle", 3));
        var result = queue.take();
        assertThat(result.getDesc(), is("middle"));
    }
}
