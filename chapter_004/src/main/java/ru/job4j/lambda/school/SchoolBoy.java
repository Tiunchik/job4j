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
 * @version 0.1
 * @since 29.12.2019
 */
public class SchoolBoy {
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
     * Геттер на переменную score
     *
     * @return возвращает уровень баллов ученика
     */
    public int getScore() {
        return score;
    }
}
