/**
 * Тестовое задание по работе с аннотацией
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
     * Метод по генерации отчёта
     *
     * @param name - имя отчёта
     * @param body - тело отчёта
     * @return - отчёт
     */
    //@Override //- нет суперкласса для переопределения
    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}