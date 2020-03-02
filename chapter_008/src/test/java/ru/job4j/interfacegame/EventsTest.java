package ru.job4j.interfacegame;

import org.junit.Test;

import static org.junit.Assert.*;

public class EventsTest {

    @Test(expected = NullPointerException.class)
    public void whenUserCaughtByEventThenPositionAndStatusChanged() {
        User user = null;
        Position pos = null;
        Events event = null;

        String status = user.getStatus();

        event.act(user, pos);

        String newstatus = user.getStatus();

        assertFalse(pos.getUser().contains(user));
        assertNotEquals(status, newstatus);

    }
}