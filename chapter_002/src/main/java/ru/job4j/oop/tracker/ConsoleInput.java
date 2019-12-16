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
 * @version 0.1
 * @since 15.12.2019
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}