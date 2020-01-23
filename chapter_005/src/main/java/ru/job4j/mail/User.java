/**
 * Пакет для работы с коллекциями, тестовое задание Почта
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.mail;

import java.util.Objects;
import java.util.Set;

/**
 * Класс User - модель данных.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 14.01.2019
 */
public class User {

    private String name;
    private Set<String> emails;

    public String getName() {
        return name;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public User(String name, Set<String> emails) {
        this.name = name;
        this.emails = emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
