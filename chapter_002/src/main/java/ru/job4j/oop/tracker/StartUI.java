/**
 * Тестовое задание по созданию консолного приложения для работы с программой
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

/**
 * Класс StartUI - основной клас связующий все остальные классы для работы консольного приложения, содержит метод main
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.7
 * @since 18.12.2019
 */
public class StartUI {
    /**
     * Метод создаёт базу данных из моделей данных item, иницилизирует объект для считывания ответов пользователя
     *
     * @param input   - объект для работы с вводом данных с клавиатуры
     * @param tracker - база данных программы, где храняться все занесенную в базу позиции
     * @param actions - база данных действий для работы с базой данных, реализованной посредством интерфейса
     */
    public void init(Input input, Tracker tracker, UserActions[] actions) {
        boolean run = true;
        int select = 0;
        while (run) {
                this.showMenu(actions);
                select = input.askInt("Select: ", actions.length);
                run = actions[select].execute(input, tracker);
            }
        }
    /**
     * Метод вывода меню перед пользователем
     *
     * @param action - база данных действий для работы с базой данных
     */
    public void showMenu(UserActions[] action) {
        System.out.println("Menu:");
        for (int index = 0; index < action.length; index++) {
            System.out.print(index + " ");
            System.out.println(action[index].name());
        }
    }

    /**
     * Метод main
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        Input input = new ValidateInput(new ConsoleInput());
        Tracker tracker = new Tracker();
        UserActions[] action = {new AddItem(), new ShowAll(), new AdjustItem(),
                new DeleteItem(), new FindItemId(), new FindItemName(), new Escape()};
        new StartUI().init(input, tracker, action);
    }
}