/**
 * Тестовое задание по созданию консолного приложения для работы с программой
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Класс Traker - класс для работы с пользователем, выводит меню
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 15.12.2019
 */
public class StartUI {
    /**
     * Метод создаёт базу данных из моделей данных item, иницилизирует объект для считывания ответов пользователя
     *
     * @param scanner - объект для работы с вводом данных с клавиатуры
     * @param tracker - база данных программы, где храняться все занесенную в базу позиции
     */
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = false;
        int select = -1;
        while (select != 6) {
            one:
            {
                this.showMenu();
                select = Integer.parseInt(scanner.nextLine());
                switch (select) {
                    case (0):
                        System.out.println("=== Create a new Item ====");
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        Item item = new Item(name);
                        tracker.add(item);
                        break;
                    case (1):
                        System.out.println("=== Create a list of Items ====");
                        Item[] array = tracker.findAll();
                        for (int i = 0; i < array.length; i++) {
                            System.out.println("Позиция: " + i + " Имя: " + array[i].getName() + " Идентификатор: "
                                    + array[i].getId());
                        }
                        break;
                    case (2):
                        System.out.println("=== Start proceduring of a replacing name ====");
                        System.out.print("Enter new name: ");
                        name = scanner.nextLine();
                        item = new Item(name);
                        System.out.print("\nEnter ID number of an adjusted item: ");
                        name = scanner.nextLine();
                        tracker.replace(name, item);
                        break;
                    case (3):
                        System.out.println("=== Start proceduring of a deleting item ====");
                        System.out.print("\nEnter ID number of a deleting item: ");
                        name = scanner.nextLine();
                        tracker.deleteById(name);
                        break;
                    case (4):
                        System.out.println("=== Start proceduring of searching ====");
                        System.out.print("\nEnter ID number for searching: ");
                        name = scanner.nextLine();
                        item = tracker.findById(name);
                        if (item != null) {
                            System.out.println("Найдена позиция - имя: " + item.getName() + " Идентификатор: "
                                    + item.getId());
                        } else {
                            System.out.println("По данному ID ничего не найдено");
                        }
                        break;
                    case (5):
                        System.out.println("=== Start proceduring of searching by name ====");
                        System.out.print("\nEnter name number for searching: ");
                        name = scanner.nextLine();
                        array = tracker.findByName(name);
                        if (array.length > 0) {
                            System.out.println("Found following positions:");
                            for (int i = 0; i < array.length; i++) {
                                System.out.println("Позиция: " + i + " Имя: " + array[i].getName() + " Идентификатор: "
                                        + array[i].getId());
                            }
                        } else {
                            System.out.println("По данному имени ничего не найдено");
                        }
                        break;
                    case (6):
                        break one;
                    default:
                        System.out.println("Didn't recognize. Please, choose again:");
                        break;
                }
            }
        }
    }

    /**
     * Метод вывода меню перед пользователем
     */
    private void showMenu() {
        System.out.println("Menu:\n"
                + "0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program\n"
                + "Select:");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}