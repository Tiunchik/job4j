/**
 * Тестовое задание по нчалу работ с шаблонами проектирования, работа над шаблоном Стратегия
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.strategy;

/**
 * Класс Square - переопределяет методы интерфейса Shape
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 16.12.2019
 */
public class Square implements Shape {
    /**
     * переопределённый метод, рисует в псевдографике квадрат
     */
    @Override
    public void drawshape() {
        for (int column = 0; column < 10; column++) {
            for (int row = 0; row < 10; row++) {
                System.out.print((char) ('A' + row));
            }
            System.out.print("\n");
        }
    }
}
