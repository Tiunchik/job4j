/**
 * Тестовое задание по отработке наследования и переопределения методов
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.textreport;

/**
 * TextReport - супер класс для всех отчётных классов
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 12.12.2019
 */
public class TextReport {
    /**
     * метод по генерации отчёта
     *
     * @param name - имя отчёта
     * @param body - тело отчёта
     * @return - отчёт
     */
    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}