/**
 * Пакет для работы с IO, создание консольного чата
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

/**
 * Класс NormalInput - реализует интерфейс ввода данных в чат бот и вывода ответов
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 21.01.2020
 */
public class NormalInput implements Input {

    @Override
    public String ask(String question, Consumer<String> consumer) throws IOException {
        consumer.accept(question);
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        return reader.readLine();
    }
}
