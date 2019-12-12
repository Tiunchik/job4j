package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqMaxTest {

    @Test
    public void testMax() {
        int expected = 8;
        Assert.assertEquals(expected, SqMax.max(8, 2, 6, 5));
        Assert.assertEquals(expected, SqMax.max(4, 8, 6, 5));
        Assert.assertEquals(expected, SqMax.max(4, 2, 8, 5));
        Assert.assertEquals(expected, SqMax.max(4, 2, 6, 8));

    }

}
