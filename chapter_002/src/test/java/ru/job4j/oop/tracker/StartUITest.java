/**
 * Тестовое задание по созданию теста для методов StartUI
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
     * Тест метода init
     */
    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserActions[] { action });
        assertThat(action.isCall(), is(true));
    }

    /**
     * Тест для метода ShowMenu
     */
    @Test
    public void showMenu() {
        PrintStream normalout = System.out;
        ByteArrayOutputStream testout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testout));
        UserActions[] test = {new StubAction()};
        StartUI start = new StartUI();
        start.showMenu(test);
        Assert.assertTrue((testout.toString().indexOf(test[0].name())) != -1);
        System.setOut(normalout);
    }
}
