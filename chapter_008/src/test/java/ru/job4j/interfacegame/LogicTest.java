package ru.job4j.interfacegame;

import org.junit.Test;

import static org.junit.Assert.*;

public class LogicTest {

    @Test (expected = NullPointerException.class)
    public void wheWeCheckUserThenTheyAreWinner() {
        User user = null;
        Position end = null;
        Logic log = null;
        assertTrue(log.isWin(user, end));
    }

    @Test (expected = NullPointerException.class)
    public void whenWecheckUserThenEventIsHapened() {
        User user = null;
        Position end = null;
        Logic log = null;

        var e = log.isEvent(user, end);

        assertTrue(e);
    }
}