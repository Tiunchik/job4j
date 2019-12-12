package ru.job4j.loop;

import org.junit.Assert;
import org.junit.Test;

public class CounterTest {

    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        int out = Counter.add(1, 10);
        int expected = 30;
        Assert.assertEquals(expected, out);
    }

    @Test
    public void BigTest() {
        int out = Counter.add(20, 30);
        int expected = 150;
        Assert.assertEquals(expected, out);
    }
}