/**
 * Тестовое задание по созданию класса для интерфейса
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

/**
 * Класс ConsoleInput - класс для перегрузки методов интерфейса Input;
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 15.12.2019
 */
public class StubInput implements Input {

    @Override
    public String askStr(String question) {
        return null;
    }

    @Override
    public int askInt(String question) {
        return 0;
    }
}
