/**
 * Пакет для работы с IO, создание консольного чата
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.chat;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * Класс Input - интерфейс ввода данных в чат бот и вывода ответов
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 21.01.2020
 */
public interface Input {

    String ask(String question, Consumer<String> consumer) throws IOException;
}
