package ru.job4j.interfacegame;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test (expected = NullPointerException.class)
    public void makeTrun() {
        User user = null;
        Board board = null;

        Position firstPos = board.findPosition(user);

        board.makeTrun(user);

        Position secPos = board.findPosition(user);

        assertFalse(firstPos.getUser().contains(user));
        assertTrue(secPos.getUser().contains(user));
    }

    @Test (expected = NullPointerException.class)
    public void executeEvent() {
        User user = null;
        Board board = null;

        Position firstPos = board.findPosition(user);

        board.executeEvent(user);

        assertFalse(firstPos.getUser().contains(user));
    }
}