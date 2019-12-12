/**
 * Тестовое задание по отработке наследования
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.tracker;

/**
 * Суперкласс. Создат для отработки команд наследования
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 12.12.2019
 */
public class Animal {
    /**
     * Переменая экземпляра содержит имя объекта
     */
    String name;
    /**
     * Эмуляция дефолтного конструктора с выделением метода super
     */
    public Animal() {
        super();
        System.out.println("Animal");
    }

    /**
     * Конструктор позволяющий задать поле name при создании объекта
     *
     * @param name - аргумент параметра будет передан в переменную экземпляра name
     */
    public Animal(String name) {
        super();
        this.name = name;
    }
}
