/**
 * Calculator package
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.calculator.anothercalculator;

/**
 * Class for executing simple arithmetic operations.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 22.02.2020
 */

public class Calculator {

    /**
     * addition of two variables.
     *
     * @param first  - first variable.
     * @param second - second variable.
     */
    public double add(double first, double second) {
        return first + second;
    }

    /**
     * subtract from the first variable the value of second variable.
     *
     * @param first  - first variable.
     * @param second - second variable.
     */
    public double subtract(double first, double second) {
        return first - second;
    }

    /**
     * multiply of two variables.
     *
     * @param first  - first variable.
     * @param second - second variable.
     */
    public double multiply(double first, double second) {
        return first * second;
    }

    /**
     * division of the first variable by value of second variable.
     *
     * @param first  - first variable.
     * @param second - second variable.
     */
    public double div(double first, double second) {
        return first / second;
    }

    /**
     * calculate sinus of argument.
     *
     * @param first value for calculatin.
     * @return sinus of argument.
     */
    public double sin(double first) {
        return Math.sin(first);
    }

    /**
     * calculate cosinus of argument.
     *
     * @param first value for calculatin.
     * @return cosinus of argument.
     */
    public double cos(double first) {
        return Math.cos(first);
    }

    /**
     * calculate tangens of argument.
     *
     * @param first value for calculatin.
     * @return tangens of argument.
     */
    public double tan(double first) {
        return Math.tan(first);
    }
}
