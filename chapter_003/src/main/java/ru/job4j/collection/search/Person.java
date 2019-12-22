/**
 * Пакет для работы/учёбы с коллекциями.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.search;
/**
 * Класс Person - класс для создания коллекции ArrayList
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 22.12.2019
 */
public class Person {
    /**
     * Переменные экземпляра класса, все приватные
     */
    private String name;
    private String surname;
    private String phone;
    private String address;

    /**
     * Конструктор для иницализации всех переменных объекта, у объекта отсутвует сеттеры!
     *
     * @param name - заносится имя
     * @param surname - заносится фамилия
     * @param phone - заносится телефон
     * @param address - заносится адрес
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Геттер для поля name
     * @return - возвращает значения поля name
     */
    public String getName() {
        return name;
    }
    /**
     * Геттер для поля surname
     * @return - возвращает значения поля surname
     */
    public String getSurname() {
        return surname;
    }
    /**
     * Геттер для поля phone
     * @return - возвращает значения поля phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Геттер для поля address
     * @return - возвращает значения поля address
     */
    public String getAddress() {
        return address;
    }
}
