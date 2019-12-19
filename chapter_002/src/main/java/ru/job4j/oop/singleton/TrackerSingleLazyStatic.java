/**
 * Пакет для отработки тестового задания по созданию паттерна singleton
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.singleton;

import ru.job4j.oop.tracker.*;
/**
 * Второй вариант отработки паттерна singleton - через блокирование доступа к возможности создать объект.
 * загрузка трэкера только после обращения к объекту по методу
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.12.2019
 */
public class TrackerSingleLazyStatic {

    private static Tracker instanse;

    private TrackerSingleLazyStatic() {
    }

    private static boolean exist = false;

    public static Tracker getInstance() {
        if (!exist) {
            exist = true;
            Tracker instanse = new Tracker();
        }
        return instanse;
    }
}
