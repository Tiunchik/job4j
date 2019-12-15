/**
 * Файл интерфеса
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

/**
 * Интерфейс Input - интерфейс для обучения работе с интерфейсами;
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 15.12.2019
 */
public interface Input {
    String askStr(String question);

    int askInt(String question);
}