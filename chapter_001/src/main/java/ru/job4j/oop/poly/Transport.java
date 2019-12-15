/**
 * Тестовое задание по работе с интерфейсом
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.poly;

/**
 * Интерфейс Transport
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 15.12.2019
 */
public interface Transport {

    void ride();

    void passengers(int i);

    double fuelUp(double gas);
}
