/**
 * Тестовый класс для класса Max, рефакторинг, работа с перегруженными методами.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.condition;

/**
 * Класс Max, рефакторинг, работа с перегруженными методами.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 11.12.2019
 */
public class Max {
    /**
     * Метод ищет максимум из двух чисел
     *
     * @param a - первое число
     * @param b - второе число
     * @return - возвращаемое максимальное значение
     */
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * Метод ищет максимум из трёх чисел
     *
     * @param a - первое число
     * @param b - второе число
     * @param c - третье число
     * @return - возвращаемое максимальное значение
     */
    public static int max(int a, int b, int c) {
        return max(a, max(b, c));
    }

    /**
     * Метод ищет максимум из четырёх чисел
     *
     * @param a - первое число
     * @param b - второе число
     * @param c - третье число
     * @param d - четвертое число
     * @return - возвращаемое максимальное значение
     */
    public static int max(int a, int b, int c, int d) {
        return max(max(a, b), max(c, d));
    }

}
