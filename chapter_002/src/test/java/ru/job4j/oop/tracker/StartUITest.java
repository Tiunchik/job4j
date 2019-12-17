/**
 * Тестовое задание по созданию теста для методов StartUI
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для класса StartUI
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 17.12.2019
 */
public class StartUITest {
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
     * Тест метода init
     */
    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[]{"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserActions[]{action});
        assertThat(action.isCall(), is(true));
    }

    /**
     * Тест для метода ShowMenu
     */
    @Test
    public void showMenu() {
        UserActions[] test = {new StubAction()};
        StartUI start = new StartUI();
        start.showMenu(test);
        Assert.assertTrue((testout.toString().indexOf(test[0].name())) != -1);
    }

    /**
     * Тест для метода ShowMenu - выполненный по заданию
     */
    @Test
    public void anotherTestshowMenu() {
        StubInput input = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserActions[] {action});
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                 .add("Menu:")
                 .add("0 Stub action")
                 .toString();
        assertThat(new String(testout.toByteArray()), is(expect));
    }
    /**
     * Тест для метода FindItemName
     */
    @Test
    public void FindByNameTest() {
        StubInput input = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserActions[] {action});
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu:")
                .add("0 Stub action")
                .toString();
        assertThat(new String(testout.toByteArray()), is(expect));
    }
}