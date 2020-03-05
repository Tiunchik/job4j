package ru.job4j.interfacegame;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {

    @Test (expected = NullPointerException.class)
    public void whenWeRolAndThneGetnumberBiggerThenZero() {
        Dice dice = null;

        int expected = dice.roll();

        assertTrue(expected > 0);
    }
}