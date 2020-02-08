package ru.job4j.magnit;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import ru.job4j.oop.tracker.*;
import ru.job4j.psqltrackering.ConnectionRollback;
import ru.job4j.psqltrackering.TrackerSQL;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static org.hamcrest.Matchers.is;

/**
 * Класс TrackerSQLTest - использован для тестов трекера с базой данной в виде SQL сервера.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 08.02.2020
 */
public class TrackerSQLTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").length, is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void anotherTestshowMenu() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            StubInput input = new StubInput(new String[]{"0"});
            StubAction action = new StubAction();
            new StartUI(input, tracker, output).init(new UserActions[]{action});
            String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                    .add("Menu:")
                    .add("0 Stub action")
                    .toString();
            assertThat(new String(out.toByteArray()), CoreMatchers.is(expect));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByNameTest() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            StubInput input = new StubInput(new String[]{"Big"});
            Item item = new Item("Big");
            item = tracker.add(item);
            new FindItemName().execute(input, tracker, output);
            String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                    .add("Found following positions:")
                    .add("Name: " + item.getName() + " ID: " + item.getId())
                    .toString();
            assertEquals(out.toString(), expect);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByAllAction() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item[] array = new Item[5];
            for (int index = 0; index < 5; index++) {
                Item item = new Item("Big" + index);
                item = tracker.add(item);
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
            assertEquals(out.toString(), expect);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}