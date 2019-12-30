/**
 * Пакет для работы с лямда выражениями и steam API
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.lambda.school;

/**
 * Класс SchoolBoy - класс модель данных
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 30.12.2019
 */
public class SchoolBoy {
    /**
     * Имя ученика
     */
    private String name;
    /**
     * Фамилия ученика
     */
    private String surname;
    /**
     * Уровень баллов ученика
     */
    private int score;

    /**
     * конструктор клсса, сразу задаёт уровень баллов ученика
     * @param x - параметр получающий аргумент с уровнем баллов ученика
     */
    public SchoolBoy(int x) {
        score = x;
    }

    /**
     *  конструктор клсса, сразу задаёт уровень баллов ученика и его имя
     * @param surname - фамилия ученика
     * @param score - уровень баллов ученика
     */
    public SchoolBoy(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }
    /**
     * Геттер на переменную score
     *
     * @return возвращает уровень баллов ученика
     */
    public int getScore() {
        return score;
    }

    /**
     * Геттер на переменную name
     *
     * @return возвращает имя ученика
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя учника
     *
     * @param name - аргумент данного параметра будет установлен как имя ученика
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * получить ффамилию ученика
     *
     * @return возвращает фамилию ученка
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Задать фамилию ученика
     *
     * @param surname - фаилия яченика
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
