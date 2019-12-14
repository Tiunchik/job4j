/**
 * Тестовое задание по работе с методом Scanner
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.io;

import java.util.*;

/**
 * Класс MagicBall - тестовый класс для работы с объектам Scanner
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 14.12.2019
 */
public class MagicBall {
    /**
     * Статический метод возвращения предсказаний
     *
     * @param i - по данной переменной выводится предсказание в консоль
     */
    public static void answer(int i) {
        switch (i) {
            case (1):
                System.out.println("Да");
                break;
            case (2):
                System.out.println("Нет");
                break;
            default:
                System.out.println("Может быть");
                break;
        }
    }

    /**
     * Метод main
     *
     * @param args - args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        String answer = input.nextLine();
        MagicBall.answer(new Random().nextInt(3));
    }
}
