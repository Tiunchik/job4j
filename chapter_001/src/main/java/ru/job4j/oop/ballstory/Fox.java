/**
 * Пакет для эмуляции истории объекта Колобок
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.ballstory;

/**
 * Класс Лиса, имеет метод "Сьесть колобка" с средними шансами на успех"
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 11.12.2019
 */
public class Fox {
    /**
     * Метод для сьедения колобка
     *
     * @param ball - передаваемый аргумент в параметр - колобок, которого пытаються съесть
     */
    public void eatBall(Ball ball) {
        if (ball.exist) {
            System.out.println("Встретилась Колобку Лиса и попытался съесть его.");
            if (Math.random() * 100 > 60) {
                System.out.println("Колобок был сьеден Лисой");
                ball.exist = false;
            } else {
                System.out.println("Сбежал колобок, укатил");
            }
        }
    }
}
