package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance (){
        int xn1 = 5;
        int yn1 = 10;
        int xn2 = 15;
        int yn2 = 20;
        double expected = 14.14; //Ожидаемое посчтал на кком то сайте в нете
        double out = Point.distance(xn1, yn1, xn2,yn2);
        Assert.assertEquals(expected, out, 0.01);

    }

}
