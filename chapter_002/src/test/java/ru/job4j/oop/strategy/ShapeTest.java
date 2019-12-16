/**
 * Тестовое задание по нчалу работ с шаблонами проектирования, работа над шаблоном Стратегия
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.strategy;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс ShapeTest - используется для автотестов созданных методов
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 16.12.2019
 */
public class ShapeTest {
    /**
     * Тест метода создания треугольника
     */
    @Test
    public void tesTriangle() {
        Shape shape = new Triangle();
        StringBuilder pic = new StringBuilder();
        pic.append("+");
        pic.append("+ +");
        pic.append("+  +");
        pic.append("+++++");
        assertThat(shape.drawshape(), is(pic.toString()));
    }

    /**
     * Тест метода создания квадрата
     */
    @Test
    public void tesSquare() {
        Shape shape = new Square();
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append("+  +");
        pic.append("+  +");
        pic.append("++++");
        assertThat(shape.drawshape(), is(pic.toString()));
    }

    /**
     * Тест метода draw в классе Paint
     *
     * @author Petr Arsentev (parsentev@yandex.ru)
     * @version $Id$
     * @since 0.1
     */
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append("+  +")
                                .append("+  +")
                                .append("++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
        System.setOut(stdout);
    }

}
