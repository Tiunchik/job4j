/**
 * Тестовое задание по работе с циклами, объектами (моделями данных)
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.library;

/**
 * Book - класс модель данных пдля хранения инфорамции по книгам
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 14.12.2019
 */
public class Book {
    /**
     * Поле класса с названием книги
     */
    private String title;
    /**
     * Полек класса с оличеством страниц книги
     */
    private int sheetsNum;

    /**
     * Конструктор для объекта Book, задаёт все внутренние поля
     *
     * @param title     - задаёт поле title
     * @param sheetsNum - задаёт поле sheetsNum
     */
    public Book(String title, int sheetsNum) {
        this.title = title;
        this.sheetsNum = sheetsNum;
    }

    /**
     * Геттер для поля класса title
     *
     * @return - взвращает значение поля title объекта
     */
    public String getTitle() {
        return title;
    }

    /**
     * Сеттер поля title
     *
     * @param title - аргумент передаваемый в параметр принимается полем класса -title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Геттер для поля класса sheetsNum
     *
     * @return - взвращает значение поля sheetsNum объекта
     */
    public int getSheetsNum() {
        return sheetsNum;
    }

    /**
     * Сеттер поля sheetsNum
     *
     * @param sheetsNum - аргумент передаваемый в параметр принимается полем класса -sheetsNum
     */
    public void setSheetsNum(int sheetsNum) {
        this.sheetsNum = sheetsNum;
    }
}
