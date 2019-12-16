/**
 * Тестовое задание по нчалу работ с шаблонами проектирования, работа над шаблоном Стратегия
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.strategy;

/**
 * Класс Paint - описывает основное поведение программы, применяет методы интерфейса Shape;
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 16.12.2019
 */
public class Paint {
    /**
     * Метод запускает выполнение метода Shape.drawshape. Метод выполняеться в зависимости от того,
     * какой объект проинициирован в методе;
     *
     * @param shape - передаваемым аргументом инициилизируется вариант выполнения метода
     */
    public void draw(Shape shape) {
        System.out.println(shape.drawshape());
    }

    /**
     * Метод main
     *
     * @param args
     */
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        paint.draw(new Square());
    }
}
