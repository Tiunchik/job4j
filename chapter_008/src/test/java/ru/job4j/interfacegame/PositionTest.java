package ru.job4j.interfacegame;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class PositionTest {

    @Test (expected = NullPointerException.class)
    public void whenWePuttUserAndThenGetUsersSet() {
        Position pos = null;
        pos.addUser(null);
        Set<User> test = pos.getUser();
        Assert.assertEquals(1, test.size());
    }

    @Test (expected = NullPointerException.class)
    public void whenWedelUserAndThneCheckisThereUser() {
        Position pos = null;
        pos.addUser(null);
        pos.delUser(null);
        Set<User> test = pos.getUser();
        Assert.assertEquals(1, test.size());
    }

    @Test (expected = NullPointerException.class)
    public void getStatus() {
        Position pos = null;
        String answer = pos.getStatus();
        Assert.assertEquals("desert", answer);
    }
}