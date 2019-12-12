/**
 * Тестовое задание по отработке наследования
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

/**
 * Подкласс. Создат для отработки команд наследования
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 12.12.2019
 */
public class Tiger extends Predator {
    /**
     * Эмуляция дефолтного конструктора с выделением метода super
     */
    public Tiger() {
        super();
        System.out.println("Tiger");
    }

    /**
     * Конструктор использующий конструктор суперкласс для задания переменной экземпляра name
     *
     * @param name - аргумент параметра будет передан в переменную экземпляра name
     */
    public Tiger(String name) {
        super(name);
    }
}
