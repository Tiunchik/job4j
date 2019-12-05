package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void secondMore () {
        int i1 = 5;
        int i2 = 18;
        int expected = 18;
        int out = Max.max(i1, i2);
        Assert.assertEquals(expected, out);
    }
    @Test
    public void firstMore () {
        int i1 = 50;
        int i2 = 18;
        int expected = 50;
        int out = Max.max(i1, i2);
        Assert.assertEquals(expected, out);
    }
    @Test
    public void equalNumbers () {
        int i1 = 25;
        int i2 = 25;
        int expected = 25;
        int out = Max.max(i1, i2);
        Assert.assertEquals(expected, out);
    }

}
