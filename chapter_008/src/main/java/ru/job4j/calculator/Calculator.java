/**
 * Calculator package
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.calculator;

/**
 * Class for executing simple arithmetic operations.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 17.02.2020
 */

public class Calculator {

    /**
     * Main calculator method - get text massive with numbers and symbol of arithmetic action.
     *
     * @param respond String[] 0 - first number, 1 - arithmetic action, 2 - second number.
     * @return result of calculation.
     */
    public double calculate(String[] respond) {

        double first = Double.parseDouble(respond[0]);
        double second = Double.parseDouble(respond[2]);
        double answer = first;
        switch (respond[1]) {
            case "+":
                answer = add(first, second);
                break;
            case "-":
                answer = subtract(first, second);
                break;
            case "/":
                answer = div(first, second);
                break;
            case "*":
                answer = multiply(first, second);
                break;
            default:
                break;
        }
        return answer;
    }


    /**
     * addition of two variables.
     *
     * @param first  - first variable.
     * @param second - second variable.
     */
    private double add(double first, double second) {
        return first + second;
    }

    /**
     * subtract from the first variable the value of second variable.
     *
     * @param first  - first variable.
     * @param second - second variable.
     */
    private double subtract(double first, double second) {
        return first - second;
    }

    /**
     * multiply of two variables.
     *
     * @param first  - first variable.
     * @param second - second variable.
     */
    private double multiply(double first, double second) {
        return first * second;
    }

    /**
     * division of the first variable by value of second variable.
     *
     * @param first  - first variable.
     * @param second - second variable.
     */
    private double div(double first, double second) {
        return first / second;
    }
}
