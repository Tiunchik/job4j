/**
 * Тестовое задание по созданию консолного приложения для работы с программой
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import java.util.function.Consumer;

/**
 * Класс StartUI - основной клас связующий все остальные классы для работы консольного приложения, содержит метод main
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.8
 * @since 29.12.2019
 */
public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод создаёт базу данных из моделей данных item, иницилизирует объект для считывания ответов пользователя
     *
     * @param actions - база данных действий для работы с базой данных, реализованной посредством интерфейса
     */
    public void init(UserActions[] actions) {
        boolean run = true;
        int select = 0;
        while (run) {
            this.showMenu(actions);
            select = input.askInt("Select: ", actions.length);
            run = actions[select].execute(input, tracker, output);
        }
    }

    /**
     * Метод вывода меню перед пользователем
     *
     * @param action - база данных действий для работы с базой данных
     */
    public void showMenu(UserActions[] action) {
        output.accept("Menu:");
        for (int index = 0; index < action.length; index++) {
            output.accept(index + " " + action[index].name());
        }
    }
}