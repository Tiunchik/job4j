/**
 * Пакет для работы с лямдlа выражениями и Steam API
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.lambda.tourism;

/**
 * Класс Profile - класс модель данных
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 29.12.2019
 */
public class Profile {
    /**
     * Хранит адрес клиента
     */
    private Address address;

    /**
     * Геттер для адреса клиента
     *
     * @return - возвращает адрес клиента
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Сеттер адреса клиента
     *
     * @param address устанавливает адресс клиента
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}
