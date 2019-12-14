/**
 * Пакет для автоматических тестов пакета Tracker
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Автоматические тесты для класса Traker
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 14.12.2019
 */
public class TrackerTest {
    /**
     * Тест метода add
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    /**
     * Тест метода findAll
     */
    @Test
    public void findAllTest() {
        Tracker basa = new Tracker();
        for (int i = 0; i < 10; i++) {
            if (i == 0 || i == 3 || i == 5 || i == 7 || i == 9) {
                basa.add(new Item("Элемент " + i));
            }
        }
        Item[] outItems = basa.findAll();
        assertThat(outItems.length, is(5));
    }

    /**
     * Тест метода findBy
     */
    @Test
    public void findByTest() {
        Tracker basa = new Tracker();
        for (int i = 0; i < 10; i++) {
            if (i == 0 || i == 3 || i == 5 || i == 7 || i == 9) {
                basa.add(new Item("Элемент"));
            }
        }
        Item[] outItems = basa.findByName("Элемент");
        assertThat(outItems.length, is(5));
    }

    /**
     * Тест метода findBy
     */
    @Test
    public void findByIdTest() {
        Tracker basa = new Tracker();
        basa.add(new Item("Элемент"));
        Item tempArray[] = basa.findByName("Элемент");
        Item temp = tempArray[0];
        assertThat(basa.findById(temp.getId()) != null, is(true));
    }
}
