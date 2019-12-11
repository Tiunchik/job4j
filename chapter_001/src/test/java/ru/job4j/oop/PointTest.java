/**
 * Тестовый класс для класс Point - определение расстояния между точками.
 * @author Maksim Tiunchik
 */
package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.oop.Point;
/**
 * Тестовый класс для класс Point - определение расстояния между точками. Рефакторинг
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 11.12.2019
 */
public class PointTest {
    /**
     * Тест метод для определение корректности работы метода в классе Point
     */
    @Test
    public void distance (){
        Point x = new Point (5,10);
        Point y = new Point (15,20);
        double expected = 14.14;
        double out = x.distance(y);
        Assert.assertEquals(expected, out, 0.01);
    }
    /**
     * Тест метод для определение корректности работы метода distance3d в классе Point в трёхмерной системе координат
     */
    @Test
    public void distance3d (){
        Point x = new Point (5,10, 6);
        Point y = new Point (15,20, 14);
        double expected = 16.248;
        double out = x.distance3d(y);
        Assert.assertEquals(expected, out, 0.01);
    }
}
