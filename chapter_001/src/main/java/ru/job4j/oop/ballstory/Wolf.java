/**
 * Пакет для эмуляции истории объекта Колобок
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.ballstory;

/**
 * Класс Заяц, имеет метод "Сьесть колобка" с высокими шансами на успех"
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 11.12.2019
 */
public class Wolf {
    /**
     * Метод для сьедения колобка
     *
     * @param ball - передаваемый аргумент в параметр - колобок, которого пытаються съесть
     */
    public void eatBall(Ball ball) {
        if (ball.exist) {
            System.out.println("Встретился Колобку Волк и попытался съесть его.");
            if (Math.random() * 100 > 40) {
                System.out.println("Колобок был сьеден Волком");
                ball.exist = false;
            } else {
                System.out.println("Сбежал колобок, укатил");
            }
        }
    }
}
