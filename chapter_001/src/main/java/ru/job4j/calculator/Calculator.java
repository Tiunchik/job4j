/**
 * Калькулятор
 * @author Maksim Tiunchik
 */

package ru.job4j.calculator;

/**
 * Класс для проведения арифмитических операций: + - * /
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @since 03.12.2019
 * @version 0.1
 */

public class Calculator {

    /**
     * Сложние двух простых переменных и вывод итога в консоль
     * @param first - первая переменная
     * @param second - вторая переменная
     */
    public static void add (double first, double second){
        double result = first + second;
        System.out.println(first + " + " +second + " = "+ result);
    }

    /**
     * Вычитание из первой постой переменной значения второй и вывод информации в консоль
     * @param first - первяа переменная, из неё вычитают
     * @param second - вторая переменная, её вычитают
     */
    public static void subtract (double first, double second){
        double result = first - second;
        System.out.println(first + " - " +second + " = "+ result);
    }

    /**
     * Умножение двух переенных друг на друга и вывод информации в консоль
     * @param first - первая перменная
     * @param second - вторая переменная
     */
    public static void multiply (double first, double second){
        double result = first * second;
        System.out.println(first + " * " +second + " = "+ result);
    }

    /**
     * Деление первой переменной на вторую и вывод результта в консоль
     * @param first - данную переменную делят
     * @param second - данной переменнй делят
     */
    public static void div (double first, double second){
        double result = first / second;
        System.out.println(first + " / " +second + " = "+ result);
    }

    /**
     * класс main
     * запускет методы класса Calculator для ручной проверки
     * @param args - args.
     */
    public static void main(String[] args) {
        add(1,1);
        div(4,2);
        multiply(2,1);
        subtract(10,5);

    }
}
