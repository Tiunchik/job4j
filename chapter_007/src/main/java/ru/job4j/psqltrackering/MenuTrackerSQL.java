/**
 * Пакет ru.job4j.pSQLtracker для работы с psql
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.psqltrackering;

import ru.job4j.oop.tracker.*;

/**
 * Класс MenuTracker - класс для запуска класса StartUI
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 29.12.2019
 */
public class MenuTrackerSQL {
    /**
     * Метод main
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        UserActions[] action = {new AddItem(), new ShowAll(), new AdjustItem(),
                new DeleteItem(), new FindItemId(), new FindItemName(), new Escape()};
        new StartUI(new ValidateInput(new ConsoleInput()), new TrackerSQL(), System.out::println).init(action);
    }

}
