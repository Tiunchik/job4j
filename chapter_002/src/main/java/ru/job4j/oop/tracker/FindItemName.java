/**
 * Тестовое задание по созданию перегружаемых методов и работе с ними посредством интерфейса.
 * Использование паттерна Стратегия
 *
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import java.util.function.Consumer;

/**
 * Один из вариантов методов для интерфейса UserActions
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.3
 * @since 18.12.2019
 */
public class FindItemName implements UserActions {

    /**
     * Метод для вывода в меню действий класса
     *
     * @return - возвращает описание действий класса
     */
    @Override
    public String name() {
        return "=== Start proceduring of searching by name ====";
    }

    /**
     * Метод выполняет действие - найти позиции по имени
     *
     * @param input   - интерфейс получчения ИД от пользоватля
     * @param tracker - трэкер - база данных, с которым ведёться работа
     */
    @Override
    public boolean execute(Input input, Tracker tracker, Consumer output) {
        String name = input.askStr("Enter name number for searching: ");
        Item[] array = tracker.findByName(name);
        if (array.length > 0) {
            output.accept("Found following positions:");
            for (Item x : array) {
                output.accept("Name: " + x.getName() + " ID: " + x.getId());
            }
        } else {
            output.accept("Didn't find anything");
        }
        return true;
    }
}
