/**
 * Тестовое задание по созданию методов в классе
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop;

/**
 * Класс для тестового задания по созданию методов в классе
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 10.12.2019
 */
public class Student {
    /**
     * Метод music - выводит в консоль "эмуляцию" игры на баяне
     */
    public void music() {
        System.out.println("Plop plop ping BLIP Bop Bop");
    }

    /**
     * Метод song - выводит в консоль "эмуляицю" пения попсовой песни
     */
    public void song() {
        System.out.println("I believe I can fly");
    }

    /**
     * Метод main
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        Student petya = new Student();
        for (byte i = 0; i <= 2; i++) {
            petya.music();
            petya.song();
        }
    }
}
