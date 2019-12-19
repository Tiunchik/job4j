/**
 * Пакет для отработки тестового задания по созданию паттерна singleton
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.singleton;

import ru.job4j.oop.tracker.*;
/**
 * Третий вариант отработки паттерна singleton - через блокирование доступа к возможности создать объект
 * и переменной INSTANCE, загрузка трэкера только после обращения к методу
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.12.2019
 */
public class TrackerSingleLazyFinal {
    private TrackerSingleLazyFinal() {
    }

    public static Tracker getINSTANCE() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    private static final Tracker INSTANCE = new Tracker();

    public static void main(String[] args) {
        Tracker track = TrackerSingleLazyFinal.getINSTANCE();
    }
}
