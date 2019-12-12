/**
 * Тестовое задание по отработке наследования, поля объектов, методы, создание линейки суперклассов
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.career;

/**
 * Суперкласс всех профессий
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 12.12.2019
 */
public class Profession {
    /**
     * Поля суперкласса
     */
    String name, surname, education;
    /**
     * Поле суперкласса - день рожденияж;
     */
    int birthday;

    /**
     * Геттер для поля name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Геттер для поля surname
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Геттер для поля education
     */
    public String getEducation() {
        return this.education;
    }

    /**
     * Геттер для поля birthday
     */
    public int getBirthday() {
        return this.birthday;
    }
}
