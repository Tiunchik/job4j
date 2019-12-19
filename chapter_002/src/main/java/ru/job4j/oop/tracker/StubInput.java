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
 * @version 0.2
 * @since 18.12.2019
 */
public class StubInput implements Input {
    /**
     * Переменная экземпляра класса, представляет собой список задаваемых вопросов для автотесат
     */
    private String[] answers;
    /**
     * Переменная экземпляра класса, представляет собой счётчик заданных вопросов
     */
    private int position = 0;

    /**
     * Конструктор класса StubInput
     *
     * @param answers
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Перегруженный метод интерфейса Input
     *
     * @param question - не используется в данном классе
     * @return - возвращает значение переменной экзмпляра answers, согласно счётчика position
     */
    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    /**
     * Перегруженный метод интерфейса Input, не используется
     *
     * @param question
     * @return
     */
    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }

    @Override
    public int askInt(String question, int max) {
        int select = askInt(question);
        if (select < 0 || select >= max) {
            throw new IllegalStateException(String.format("Out of about %s > [0, %s]", select, max));
        }
        return select;
    }
}