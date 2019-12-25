/**
 * Пакет для эмуляции истории объекта Колобок
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.ballstory;

/**
 * Класс колобок, имеет метод "Побег из Шоушенка", может спасти колобку его круглую шкуру
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 11.12.2019
 */
public class Ball {
    /**
     * Переменная описывающее состояниеколобка
     */
    public boolean exist = true;

    /**
     * Конструктор класса Ball, выводит информацию при создании объекта
     */
    Ball() {
        System.out.println("Жил да был колобок, да собрался он свалить от бабки с дедом"
                + ", но не тут то было...");
    }

    /**
     * Если колобка сьели, анный метод ему поможет.
     */
    public void shawshankRedemption() {
        if (!(this.exist)) {
            if (Math.random() * 100 > 20) {
                System.out.println("Но он вырвался, сбежал, укатил без обратного адреса");
                this.exist = true;
            } else {
                System.out.println("Не вырвался, сьели :'(");
            }
        }
    }
}
