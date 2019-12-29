/**
 * Тестовое задание по реализации действий в программе посредством стратегии
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import java.util.function.Consumer;

/**
 * интерфейс для вызова действия с "базой данны"
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 17.12.2019
 */
public interface UserActions {
    /**
     * Метож записи имён всех используемых функций
     * @return - возвращает имена используемых классо
     */
    public String name();

    /**
     * Перегружаемый метод интерфейса
     *
     * @param input - переменная получеия данных от пользователя
     * @param tracker - база данных с которой происходит работа
     * @return - если false - прерывание работы программы
     */
    public boolean execute(Input input, Tracker tracker, Consumer consumer);

}
