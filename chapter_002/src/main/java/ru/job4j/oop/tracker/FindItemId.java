/**
 * Тестовое задание по созданию перегружаемых методов и работе с ними посредством интерфейса.
 * Использование паттерна Стратегия
 *  *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter ID number for searching: ");
        Item item = tracker.findById(name);
        if (item != null) {
            System.out.println("Found position - name: " + item.getName() + " ID: "
                    + item.getId());
        } else {
            System.out.println("Didn't find anything");
        }
        return true;
    }
}
