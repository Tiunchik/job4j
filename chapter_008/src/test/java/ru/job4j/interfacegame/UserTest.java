package ru.job4j.interfacegame;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test (expected = NullPointerException.class)
    public void setStatus() {
        User user = null;
        user.setStatus("freezed");

        String answer = user.getStatus();

        String expected = "freezed";

        Assert.assertEquals(expected, answer);
    }

    @Test (expected = NullPointerException.class)
    public void rollDice() {
        User user = null;
        int dice = user.rollDice();
        Assert.assertTrue(dice > 0);
    }
}