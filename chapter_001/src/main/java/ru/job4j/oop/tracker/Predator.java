/**
 * Тестовое задание по отработке наследования
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

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

    /**
     * Конструктор использующий конструктор суперкласс для задания переменной экземпляра name
     *
     * @param name - аргумент параметра будет передан в переменную экземпляра name
     */
    public Predator(String name) {
        super(name);
    }
}
