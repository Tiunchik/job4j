/**
 * Тестовое задание по созданию класса для интерфейса
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import java.util.Scanner;

/**
 * Класс ConsoleInput - класс для перегрузки методов интерфейса Input;
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 18.12.2019
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Метод получения данных в формате int, в метод отсутвует исключение на случай получения текстовоо значения
     *
     * @param question данны текст выводиться в консоль, задаётся вопрос пользователю
     * @return получаемые данные типа int
     */
    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }

    /**
     * Перегруженный метод. В методе осуществлена борьба с исключением - ввод некорректного значения, но верного типа
     *
     * @param question - данны текст выводиться в консоль, задаётся вопрос пользователю
     * @param max      предел допустимого значения от ользователя, от 0 до max
     * @return - получаемые данные типа int, от 0 до max
     */
    @Override
    public int askInt(String question, int max) {
        int select = askInt(question);
        if (select >= 0 && select < max) {
            return select;
        } else {
            throw new IllegalStateException(String.format("Out of about %s > [0, %s]", select, max));
        }
    }
}