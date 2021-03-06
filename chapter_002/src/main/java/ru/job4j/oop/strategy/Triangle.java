/**
 * Тестовое задание по нчалу работ с шаблонами проектирования, работа над шаблоном Стратегия
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.strategy;

/**
 * Класс Triangle - переопределяет методы интерфейса Shape
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 16.12.2019
 */
public class Triangle implements Shape {
    /**
     * переопределённый метод, формирует фигуру треугольник в строку
     */
    @Override
    public String drawshape() {
        StringBuilder pic = new StringBuilder();
        pic.append("+");
        pic.append("+ +");
        pic.append("+  +");
        pic.append("+++++");
        return pic.toString();
    }
}

