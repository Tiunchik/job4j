/**
 * Тестовое задание по отработке наследования
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.tracker;

/**
 * Суперкласс/Подкласс. Создат для отработки команд наследования
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 12.12.2019
 */
public class Predator extends Animal {
    /**
     * Эмуляция дефолтного конструктора с выделением метода super
     */
    public Predator() {
        super();
        System.out.println("Predator");
    }
}
