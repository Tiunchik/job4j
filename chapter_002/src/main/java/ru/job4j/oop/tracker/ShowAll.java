/**
 * Тестовое задание по созданию перегружаемых методов и работе с ними посредством интерфейса.
 * Использование паттерна Стратегия
 *  *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import java.util.function.Consumer;

/**
 * Один из вариантов методов для интерфейса UserActions
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 17.12.2019
 */
public class ShowAll implements UserActions {

    /**
     * Метод для вывода в меню действий класса
     * @return - возвращает описание действий класса
     */
    @Override
    public String name() {
        return "=== Create a list of Items ====";
    }
    /**
     * Метод выполняет действие - показать все позиции в трекере
     *
     * @param input   - интерфейс получчения ИД от пользоватля
     * @param tracker - трэкер - база данных, с которым ведёться работа
     */
    @Override
    public boolean execute(Input input, ITracker tracker, Consumer output) {
        Item[] array = tracker.findAll();
        for (int i = 0; i < array.length; i++) {
            output.accept("Position: " + i + " Name: " + array[i].getName() + " ID: "
                    + array[i].getId());
        }
        return true;
    }
}
