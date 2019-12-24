/**
 * Тестирование сортировки (компоратора) для объекта типа Item
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CompareTest {

    @Test
    public void compareUp() {
        Item[] array = new Item[5], temp = new Item[5];
        Tracker tracker = new Tracker();
        for (int index = 0; index < 5; index++) {
            Item item = new Item(('A' + index) + "");
            tracker.add(item);
            temp = tracker.findByName(('A' + index) + "");
            array[index] = temp[0];
        }
        tracker.sorter(false, tracker);
        temp = tracker.findAll();
        boolean test = true;
        for (int i = 0, j = array.length - 1; i < array.length; i++, j--) {
            if (!(array[i].getId().equals(temp[j].getId()))) {
                test = false;
                break;
            }
        }
        assertTrue(test);
    }
}

