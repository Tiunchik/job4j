/**
 * Тестовое задание по работе с циклами, объектами (моделями данных) - удаление значений в массиве и его сортировка
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.pojo;

/**
 * Product - класс модель данных для хранения инфорамции по товарам
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 14.12.2019
 */
public class Product {
    /**
     * Поле хранит имя товара
     */
    private String name;
    /**
     * Поле хранит количество товара
     */
    private int count;

    /**
     * Конструктор клсса Producе для заполнение всех полей объекта
     *
     * @param name  - аргумент параметра name передаётся в перееную экземпляра name
     * @param count - аргумент параметра count передаётся в перееную экземпляра count
     */
    public Product(String name, int count) {
        this.name = name;
        this.count = count;
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

    /**
     * Геттер для поля класса м
     *
     * @return - взвращает значение поля count объекта
     */
    public int getCount() {
        return count;
    }

    /**
     * Сеттер поля count
     *
     * @param count - аргумент передаваемый в параметр принимается полем класса -count
     */
    public void setCount(int count) {
        this.count = count;
    }
}