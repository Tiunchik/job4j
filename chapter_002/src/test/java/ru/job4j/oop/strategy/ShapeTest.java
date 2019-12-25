/**
 * Тестовое задание по нчалу работ с шаблонами проектирования, работа над шаблоном Стратегия
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс ShapeTest - используется для автотестов созданных методов
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 17.12.2019
 */
public class ShapeTest {
    /**
     * Переменная записывает в себя ссылку на объект выполняющий функции вывода данных в консоль
     */
    private final PrintStream stdout = System.out;
    /**
     * Переменная записывает в себя ссылку на буфер, где может храниться выводимая в консоль информация
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * В данном методе вывод в консоль заменяется выводом в созданный ранее буфер.
     */
    @Before
    public void readFromBuffer() {
        System.out.println("print before tests");
        System.setOut(new PrintStream(out));
    }

    /**
     * в данном методе возвращаеться вывод в консоль
     */
    @After
    public void readFromConsole() {
        System.setOut(stdout);
        System.out.println("print after test");
    }

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
    }

}
