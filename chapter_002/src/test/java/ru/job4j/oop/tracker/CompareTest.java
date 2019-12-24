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

public class CompareTest {
    /**
     * Переменная записывает в себя ссылку на объект выполняющий функции вывода данных в консоль
     */
    private final PrintStream normalout = System.out;
    /**
     * Переменная записывает в себя ссылку на буфер, где может храниться выводимая в консоль информация
     */
    private final ByteArrayOutputStream testout = new ByteArrayOutputStream();

    /**
     * В данном методе вывод в консоль заменяется выводом в созданный ранее буфер.
     */
    @Before
    public void readFromBuffer() {
        System.setOut(new PrintStream(testout));
    }

    /**
     * в данном методе возвращаеться вывод в консоль
     */
    @After
    public void readFromConsole() {
        System.setOut(normalout);
    }
    /**
     * Тест для метода ShowAll
     */

    @Test
    public void compareUp() {
        Item[] array = new Item[5], temp = new Item[1];
        Tracker tracker = new Tracker();
        for (int index = 0; index <5; index++) {
            Item item = new Item(('A' + index) + "");
            tracker.add(item);
            temp = tracker.findByName(('A' + index) + "");
            array[index] = temp[0];
        }
        tracker.sorter(false, tracker);
        new ShowAll().execute(new StubInput(new String []{}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Position: " + 0 + " Name: " + array[4].getName() + " ID: " + array[4].getId())
                .add("Position: " + 1 + " Name: " + array[3].getName() + " ID: " + array[3].getId())
                .add("Position: " + 2 + " Name: " + array[2].getName() + " ID: " + array[2].getId())
                .add("Position: " + 3 + " Name: " + array[1].getName() + " ID: " + array[1].getId())
                .add("Position: " + 4 + " Name: " + array[0].getName() + " ID: " + array[0].getId())
                .toString();
        assertThat(new String(testout.toByteArray()), is(expect));
    }
}

