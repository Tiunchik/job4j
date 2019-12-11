/**
 * Тестовое задание по созданию класс Cat, работа с состоянием экземпляров
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop;

/**
 * Класс для тестового задания по созданию класс Cat, добавленеим ему переменных экземпляра
 * добавлением простых геттров и сеттеров
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 11.12.2019
 */
public class Cat {
    /**
     * Переменная типа String - описывает текущую еду объекта Кот
     */
    private String food;
    /**
     * Переменная типа String - содержит имя объекта Кот
     */
    private String name;

    /**
     * Выводит в консоль значение переменной экземпляра food
     */
    public void show() {
        System.out.println("Кота зовут " + this.name);
        System.out.println("И он ест " + this.food);
    }

    /**
     * Присваевает переменной  food значение
     *
     * @param meat - присваемое значение
     */
    public void eat(String meat) {
        this.food = meat;
    }

    /**
     * Присваевает объекту имя (переменная name;
     *
     * @param nick - присваемое имя
     */
    public void giveNick(String nick) {
        this.name = nick;
    }

    /**
     * метод main
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        //System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.eat("Котлета");
        gav.giveNick("Gav");
        gav.show();
        //System.out.println("There are black's food.");
        Cat black = new Cat();
        black.giveNick("Чернышь");
        black.eat("Рыбный паштет");
        black.show();
    }
}