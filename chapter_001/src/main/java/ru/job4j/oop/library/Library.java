/**
 * Тестовое задание по работе с циклами, объектами (моделями данных)
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.library;

/**
 * Library - класс для проверки работы модели данных Book и работы с объектми через цикл
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 14.12.2019
 */
public class Library {
    /**
     * Метод main - используеться для работы с моделью данных и циклом
     *
     * @param args
     */
    public static void main(String[] args) {
        Book one = new Book("Head First Java 2nd edition", 708);
        Book two = new Book("Thinking in Java", 1170);
        Book three = new Book("The complete reference. Java ninth edition", 1377);
        Book four = new Book("Clean code: A hanbbook of Agile Software Craftsmanship", 466);
        Book[] arrayBooks = {one, two, three, four};
        Book temp;
        for (int index = 0; index != arrayBooks.length; index++) {
            temp = arrayBooks[index];
            System.out.println("Book " + temp.getTitle() + " containts " + temp.getSheetsNum() + " pages");
        }
        temp = arrayBooks[0];
        arrayBooks[0] = arrayBooks[3];
        arrayBooks[3] = temp;
        for (int index = 0; index != arrayBooks.length; index++) {
            temp = arrayBooks[index];
            if (temp.getTitle().indexOf("Clean code") != -1) {
                System.out.print("\n");
                System.out.println("Book " + temp.getTitle() + " containts " + temp.getSheetsNum() + " pages");
            }
        }
    }
}
