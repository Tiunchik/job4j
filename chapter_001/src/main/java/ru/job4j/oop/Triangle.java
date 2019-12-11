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
 * @version 0.1
 * @since 11.12.2019
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
     * Конструктор объекта Треугольник, получает местоположение всех вершин из которых планируеться построить
     * треугольник в виде типа Point
     *
     * @param x - первая вершина
     * @param y - вторая вершина
     * @param z - третья вершина
     */
    public Triangle(Point x, Point y, Point z) {
        this.one = x;
        this.two = y;
        this.three = z;
    }

    /**
     * Метод проверяет возможность построить треугольник с заданными в нём вершинами
     *
     * @return - возвращаемое логическое значение о возможности построить треугольник
     * <p>
     * Видно не до конца понимаю эту задачу - между тремя точками всегда можно построить треугольник
     */
    public boolean exist() {
        double a = this.one.distance(this.two);
        double c = this.one.distance(this.three);
        double b = this.three.distance(this.two);
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
        double a = this.one.distance(this.two);
        double c = this.one.distance(this.three);
        double b = this.three.distance(this.two);
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
        double a = this.one.distance(this.two);
        double c = this.one.distance(this.three);
        double b = this.three.distance(this.two);
        double p = this.period();
        if (this.exist()) {
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return -1;
    }
}
