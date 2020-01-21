package ru.job4j.time;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {

    @Test
    public void getTimeFromUSA() {
        String test = new Time().getTime();
        assertNotNull(test);
    }
}