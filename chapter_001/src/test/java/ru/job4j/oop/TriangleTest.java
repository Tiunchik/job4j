/**
 * Тестовый класс для класса Triangle - определение
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Тест класс для проверки методов класса треуольник, который представляет из себя треугольникпостроенный между тремя точками
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 11.12.2019
 */
public class TriangleTest {
    /**
     * Тест на суещствование треугольника, на текущий момент - всегда корректный
     */
    @Test
    public void whenExist() {
        Point x1 = new Point (1,2);
        Point y1 = new Point (6,7);
        Point z1 = new Point (10,1);
        Triangle one = new Triangle(x1,y1,z1);
        assertThat(one.exist(), is(true));
        Point x2 = new Point (1,2);
        Point y2 = new Point (6,7);
        Point z2 = new Point (10,1);
        Triangle two = new Triangle(x1,y1,z1);
        assertThat(one.exist(), is(true));
        assertThat(two.exist(), is(true));
    }

    /**
     * Тест класс для расчёта периметра (почему на сайте периметр это длина всех
     * сторон делённая на два?, это полуперимтер)
     */
    @Test
    public void period() {
        Point x1 = new Point (1,1);
        Point y1 = new Point (2,5);
        Point z1 = new Point (10,10);
        Triangle one = new Triangle(x1,y1,z1);
        Assert.assertEquals(one.period(), 13.143, 0.1);
    }

    /**
     * Тест расчёта площади треугольника
     */
    @Test
    public void area() {
        Point x1 = new Point (1,1);
        Point y1 = new Point (2,5);
        Point z1 = new Point (10,10);
        Triangle one = new Triangle(x1,y1,z1);
        Assert.assertEquals(one.area(), 13.5, 0.1);
    }

}