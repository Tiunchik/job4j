/**
 * Пакет для работы с лямдlа выражениями и Steam API
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.lambda.tourism;

/**
 * Класс Address - класс модель данных
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 29.12.2019
 */
public class Address {
    /**
     * Содержит город проживания клиента
     */
    private String city;
    /**
     * Содержит улицу проживания клиента
     */
    private String street;
    /**
     * Содержит номер дома проживания клиента
     */
    private int home;
    /**
     * Содержит номер квартиры проживания клиента
     */
    private int apartment;

    /**
     * Конструктор класса
     *
     * @param city - город клиента
     * @param street - улица клиента
     * @param home - дом клиента
     * @param apartment - квартира клиента
     */
    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    /**
     * Геттер города клиента
     *
     * @return - возвращает город клиента
     */
    public String getCity() {
        return city;
    }

    /**
     * Геттер улицы клиента
     *
     * @return - возвращает улицу клиента
     */
    public String getStreet() {
        return street;
    }

    /**
     * Геттер дома клиента
     *
     * @return - возвращает дом клиента
     */
    public int getHome() {
        return home;
    }

    /**
     * Геттер аппартаментов клиента
     *
     * @return - возвращает аппартаменты клиента
     */
    public int getApartment() {
        return apartment;
    }
}
