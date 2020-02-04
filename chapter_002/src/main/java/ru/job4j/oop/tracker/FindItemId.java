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
public class FindItemId implements UserActions {

    /**
     * Метод для вывода в меню действий класса
     * @return - возвращает описание действий класса
     */
    @Override
    public String name() {
        return "=== Start proceduring of searching ====";
    }
    /**
     * Метод выполняет действие - найти позицию в трекере по ID
     *
     * @param input   - интерфейс получчения ИД от пользоватля
     * @param tracker - трэкер - база данных, с которым ведёться работа
     */
    @Override
    public boolean execute(Input input, ITracker tracker, Consumer output) {
        String name = input.askStr("Enter ID number for searching: ");
        Item item = tracker.findById(name);
        if (item != null) {
            output.accept("Found position - name: " + item.getName() + " ID: "
                    + item.getId());
        } else {
            output.accept("Didn't find anything");
        }
        return true;
    }
}
