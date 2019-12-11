/**
 * Пакет для эмуляции истории объекта Колобок
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.ballstory;

/**
 * Управляющий класс, рассказывает историю колобка
 */
public class BallStory {
    /**
     * Метод main
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        Ball kolob = new Ball();
        Hare skew = new Hare();
        Fox red = new Fox();
        Wolf were = new Wolf();
        skew.eatBall(kolob);
        kolob.shawshankRedemption();
        red.eatBall(kolob);
        kolob.shawshankRedemption();
        were.eatBall(kolob);
        kolob.shawshankRedemption();
    }
}
