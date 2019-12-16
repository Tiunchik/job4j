/**
 * Тестовое задание по созданию обёртки над массивом
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

/**
 * Класс Item - модель данных
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 14.12.2019
 */
public class Item {
    /**
     * id - индивидуальная переменная для каждого элемента массива
     */
    private String id;
    /**
     * Имя элемента, содржащегося в массиве
     */
    private String name;

    /**
     * Конструктор для объекта item - автоматически заполняет поле name согласно аргумента
     * принятоого параметром конструктора
     *
     * @param name - данное значение будет назначено плю name
     */
    public Item(String name) {
        this.name = name;
    }

    /**
     * Геттер для поля класса id
     *
     * @return - взвращает значение поля id объекта
     */
    public String getId() {
        return id;
    }

    /**
     * Сеттер поля id
     *
     * @param id - аргумент передаваемый в параметр принимается полем класса -id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Геттер для поля класса name
     *
     * @return - взвращает значение поля name объекта
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер поля name
     *
     * @param name - аргумент передаваемый в параметр принимается полем класса -name
     */
    public void setName(String name) {
        this.name = name;
    }
}