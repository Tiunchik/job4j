/**
 * Тестовое задание по работе с интерфейсом
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.poly;

/**
 * Класс Buss - переопределяет методы интерфейся Transport
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 15.12.2019
 */
public class Buss implements Transport {

    @Override
    public void ride() {
        System.out.println("Автобус доехал до следующей остановки");
    }

    @Override
    public void passengers(int i) {
        if (i > 0) {
            System.out.println("Пассажиров в атобсе стало на " + i + " больше");
        } else if (i == 0) {
            System.out.println("На остановке никто не сел в автобс");
        } else {
            System.out.println("Пассажиров в атобсе стало на " + i + " меньше");
        }

    }

    @Override
    public double fuelUp(double gas) {
        System.out.println("Автобус заправили на " + gas + "литров топлива");
        return gas;
    }
}
