/**
 * Тестовый класс для класса Triangle - определение
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop;

/**
 * Класс треуольник, представляет из себя треугольникпостроенный между тремя точками
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 12.12.2019
 */
public class Triangle {
    /**
     * Одна из вершин треугольника, привязанная в двухмерной координатной сетке
     */
    private Point one;
    /**
     * Одна из вершин треугольника, привязанная в двухмерной координатной сетке
     */
    private Point two;
    /**
     * Одна из вершин треугольника, привязанная в двухмерной координатной сетке
     */
    private Point three;
    /**
     * Длина одной из сторон треугольника
     */
    private double a;
    /**
     * Длина одной из сторон треугольника
     */
    private double b;
    /**
     * Длина одной из сторон треугольника
     */
    private double c;

    /**
     * Конструктор объекта Треугольник, получает местоположение всех вершин из которых планируеться построить
     * треугольник в виде типа Point
     *
     * @param x - первая вершина
     * @param y - вторая вершина
     * @param z - третья вершина
     */
    public Triangle(Point x, Point y, Point z) {
        one = x;
        two = y;
        three = z;
        a = x.distance(y);
        c = x.distance(z);
        b = y.distance(z);
    }

    /**
     * Метод проверяет возможность построить треугольник с заданными в нём вершинами
     *
     * @return - возвращаемое логическое значение о возможности построить треугольник
     * <p>
     * Видно не до конца понимаю эту задачу - между тремя точками всегда можно построить треугольник
     */
    public boolean exist() {
        if (a + b > c && a + c > b && c + b > a) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод высчитывает периметр треугольника
     *
     * @return - вовзращает периметр треугольника типа double
     */
    public double period() {
        if (this.exist()) {
            return (a + b + c) / 2;
        }
        return -1;
    }

    /**
     * Метод высчитывает площадь треугольника
     *
     * @return - возвращает площадь треугольника типа double
     */
    public double area() {
        double p = this.period();
        if (this.exist()) {
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return -1;
    }
}
