/**
 * Пакет для тестового задания "Банковские переводы"
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.bank;

import java.util.Objects;

/**
 * Класс User - класс модель данных
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 28.12.2019
 */
public class User {
    /**
     * Содержит имя держателя счета
     */
    private String name;
    /**
     * Содержит паспортные данные держателя счета
     */
    private String passportN;

    /**
     * Конструктор инициализирующий поля класса
     *
     * @param name - аргумент передается в поле name
     * @param pass - аргумент передается в поле pass
     */
    public User(String name, String pass) {
        this.name = name;
        this.passportN = pass;
    }

    /**
     * Метод возвращает имя держателя счета
     *
     * @return возвращает имя держателя счета
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает паспортные данные держателя счета
     *
     * @return возвращает паспортные данные держателя счета
     */
    public String getPassportN() {
        return passportN;
    }

    /**
     * Переопределение метода hashCode
     *
     * @return возвращает hashCod для объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(getPassportN());
    }

    /**
     * Переопределение метода equals
     *
     * @param obj - объект User
     * @return - возвращает 1 если сравниваемые объекты равны и 0 если нет
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        return hashCode() == obj.hashCode();
    }
}
