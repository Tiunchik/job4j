/**
 * Пакет для работы с IO, создание консольного чата
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.chat;

import java.util.function.Consumer;

/**
 * Класс TestInput - реализует интерфейс ввода данных в чат бот и вывода ответов
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 21.01.2020
 */
public class TestInput implements Input {

    String[] answer;
    int index = 0;

    public TestInput(String[] answer) {
        this.answer = answer;
    }

    @Override
    public String ask(String question, Consumer<String> consumer) {
        consumer.accept(question);
        return answer[index++];
    }


}
