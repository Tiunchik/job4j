/**
 * Пакет для тестирования разрботанных классов по паттерну singleton
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.singleton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.oop.tracker.Tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SingletonTest {

    @Test
    public void trackerSingleEnun(){
        Tracker first = TrackerSingleEnun.INSTANCE.getTracker();
        Tracker second = TrackerSingleEnun.INSTANCE.getTracker();
        assertEquals(first,second);
    }

    @Test
    public void trackerSingleLazyStatic(){
        Tracker first = TrackerSingleLazyStatic.getInstance();
        Tracker second = TrackerSingleLazyStatic.getInstance();
        assertEquals(first,second);
    }

    @Test
    public void trackerSingleEagerLoading(){
        Tracker first = TrackerSingleEagerLoading.getINSTANCE();
        Tracker second = TrackerSingleEagerLoading.getINSTANCE();
        assertEquals(first,second);
    }

    @Test
    public void trackerSingleLazyFinal(){
        Tracker first = TrackerSingleLazyFinal.getInstance();
        Tracker second = TrackerSingleLazyFinal.getInstance();
        assertEquals(first,second);
    }
}
