/**
 * Пакет для отработки тестового задания по созданию паттерна singleton
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.singleton;

import ru.job4j.oop.tracker.*;
/**
 * Первый вариант отработки паттерна singleton - через enum/INSTANCE, загрузка сразу по созданию объекта
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.12.2019
 */
public enum TrackerSingleEnun {
    INSTANCE;

    private final Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return this.tracker;
    }
}
