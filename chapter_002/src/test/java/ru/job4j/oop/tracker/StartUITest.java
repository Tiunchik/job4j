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
import java.util.function.Consumer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import ru.job4j.oop.tracker.Tracker;

/**
 * Тесты для класса StartUI
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 29.12.2019
 */
public class StartUITest {
    /**
     * Переменная для хранения выводмой/перехватываемой информации от тсотвых методов
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    /**
     * Преопредление метода объекта функционального класса для его дальнейшего использования в тесатх
     */
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };
        /**
         * Тест метода init
         */
        @Test
        public void whenExit() {
            StubInput input = new StubInput(
                    new String[]{"0"}
            );
            StubAction action = new StubAction();
            new StartUI(input, new Tracker(), output).init(new UserActions[]{action});
            assertThat(action.isCall(), is(true));
        }

        /**
         * Тест для метода ShowMenu
         */
        @Test
        public void showMenu() {
            UserActions[] test = {new StubAction()};
            StartUI start = new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), output);
            start.showMenu(test);
            Assert.assertTrue(out.toString().contains(test[0].name()));
        }

        /**
         * Тест для метода ShowMenu - выполненный по заданию
         */
        @Test
        public void anotherTestshowMenu() {
            StubInput input = new StubInput(new String[]{"0"});
            StubAction action = new StubAction();
            new StartUI(input, new Tracker(), output).init(new UserActions[]{action});
            String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                    .add("Menu:")
                    .add("0 Stub action")
                    .toString();
            assertThat(new String(out.toByteArray()), is(expect));
        }

        /**
         * Тест для метода FindItemName
         */
        @Test
        public void findByNameTest() {
            StubInput input = new StubInput(new String[]{"Big"});
            Tracker tracker = new Tracker();
            Item item = new Item("Big");
            tracker.add(item);
            new FindItemName().execute(input, tracker, output);
            String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                    .add("Found following positions:")
                    .add("Name: " + item.getName() + " ID: " + item.getId())
                    .toString();
            assertThat(new String(out.toByteArray()), is(expect));
        }

        /**
         * Тест для метода ShowAll
         */
        @Test
        public void findByAllAction() {
            Item[] array = new Item[5];
            Tracker tracker = new Tracker();
            for (int index = 0; index < 5; index++) {
                Item item = new Item("Big" + index);
                tracker.add(item);
                array[index] = item;
            }
            new ShowAll().execute(new StubInput(new String[]{}), tracker, output);
            String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                    .add("Position: " + 0 + " Name: " + array[0].getName() + " ID: " + array[0].getId())
                    .add("Position: " + 1 + " Name: " + array[1].getName() + " ID: " + array[1].getId())
                    .add("Position: " + 2 + " Name: " + array[2].getName() + " ID: " + array[2].getId())
                    .add("Position: " + 3 + " Name: " + array[3].getName() + " ID: " + array[3].getId())
                    .add("Position: " + 4 + " Name: " + array[4].getName() + " ID: " + array[4].getId())
                    .toString();
            assertThat(new String(out.toByteArray()), is(expect));
        }
    }