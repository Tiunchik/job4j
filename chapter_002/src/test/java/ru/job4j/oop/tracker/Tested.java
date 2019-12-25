package ru.job4j.oop.tracker;

import java.util.StringJoiner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Tested {

    public void compareUp() {

    }

    public static void main(String[] args) {
        Item[] array = new Item[5];
        Tracker tracker = new Tracker();
        for (int index = 0; index < 5; index++) {
            Item item = new Item(('A' + index) + "");
            tracker.add(item);
            array[index] = item;
        }
        tracker.sorter(false, tracker);
        new ShowAll().execute(new StubInput(new String[]{}), tracker);
    }
}
