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
     * Метод main
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        Shape pictureOne = new Square();
        pictureOne.drawshape();
        Shape pictureTwo = new Triangle();
        pictureTwo.drawshape();
    }
}
