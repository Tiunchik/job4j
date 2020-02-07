/**
 * Пакет ru.job4j.pSQLtracker для работы с psql
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.psqltrackering;

import ru.job4j.oop.tracker.*;

import java.io.IOException;

/**
 * Класс MenuTracker - класс для запуска класса StartUI
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 08.02.2020
 */
public class MenuTrackerSQL {
    /**
     * Метод main
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        try (TrackerSQL temp = new TrackerSQL()) {
            UserActions[] action = {new AddItem(), new ShowAll(), new AdjustItem(),
                    new DeleteItem(), new FindItemId(), new FindItemName(), new Escape()};
            new StartUI(new ValidateInput(new ConsoleInput()), temp, System.out::println).init(action);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
