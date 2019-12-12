package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {

    @Test
    public void manWeight() {
        double in = 140.0;
        double expected = 46.00;
        double out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }
// не захтел включать тест пока я не снял static с опредлений к методу

    @Test
    public void womanWeight() {
        double in = 160.0;
        double expected = 57.50;
        double out = Fit.womanWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }

}
