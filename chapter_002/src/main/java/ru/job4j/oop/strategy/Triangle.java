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
     * переопределённый метод, рисует в псевдографике треугольник
     */
    @Override
    public void drawshape() {
        char let = 'A';
        for (int column = 1; column < 11; column++) {
            for (int row = 0; row < column; row++) {
                System.out.print((char) ('A' + row));
            }
            System.out.print("\n");

        }
    }
}
