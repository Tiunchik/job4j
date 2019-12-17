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
public class AdjustItem implements UserActions {

    /**
     * Метод для вывода в меню действий класса
     * @return - возвращает описание действий класса
     */
    @Override
    public String name() {
        return "=== Start proceduring of a replacing name ====";
    }
    /**
     * Метод выполняет действие - откорректировать позицию в трекере
     *
     * @param input   - интерфейс получчения ИД от пользоватля
     * @param tracker - трэкер - база данных, с которым ведёться работа
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        name = input.askStr("Enter ID number of an adjusted item: ");
        if (tracker.replace(name, item)) {
            System.out.println("Item was adjusted");
        } else {
            System.out.println("ID is incorrect. Try again");
        }
        return true;
    }
}
