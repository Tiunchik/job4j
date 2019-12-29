/**
 * Пакет для работы с лямдда выражениями и Steam API
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.lambda.tourism;

import java.util.Objects;

/**
 * Класс Address - класс модель данных
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
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
     * @param city      - город клиента
     * @param street    - улица клиента
     * @param home      - дом клиента
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

    /**
     * Переопредление метода equals - даже не пришлось копировать и преписывать, IDEA сама сформировала
     *
     * @param o - сравнение идёт с даным объектом
     * @return 1 если объекты идентичны, 0 если разные
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && city.equals(address.city)
                && street.equals(address.street);
    }

    /**
     * Переопределение метода формирования hashCode - даже не пришлось копировать и преписывать, IDEA сама сформировала
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }

    /**
     * Переопределение метода формирования toString - даже не пришлось копировать и преписывать, IDEA сама сформировала
     *
     * @return возвращает текстовое значение адреса клиента
     */
    @Override
    public String toString() {
        return "Address{"
                + "city= " + city + '\''
                + ", street= " + street + '\''
                + ", home= " + home
                + ", apartment= " + apartment + '}';
    }
}
