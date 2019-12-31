/**
 * Пакет для работы/учёбы с коллекциями.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.account;

import java.util.Objects;

/**
 * Класс Account - класс модель данных
 *
 * @author -
 * @version 0.1
 * @since 31.12.2019
 */
public class Account {
    /**
     * паспортные данные
     */
    private String passport;
    /**
     * имя
     */
    private String username;
    /**
     * номер счёта
     */
    private String deposit;

    /**
     * конструктор
     *
     * @param passport - паспортные данные
     * @param username - имя
     * @param deposit - номер счёта
     */
    public Account(String passport, String username, String deposit) {
        this.passport = passport;
        this.username = username;
        this.deposit = deposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(passport, account.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return "Account{"
                + "passport='" + passport + '\''
                + ", username='" + username + '\''
                + ", deposit='" + deposit + '\''
                + '}';
    }
}