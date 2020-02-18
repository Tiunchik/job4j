/**
 * Calculator package
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Класс RngCalculator - extender of class Calculator, extends opportunities of parent class,
 * add some trigonometric calculations.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 18.02.2020
 */
public class RngCalculator extends Calculator {
    private static final Logger LOG = LogManager.getLogger(RngCalculator.class.getName());

    /**
     * constant for checking second argument of massive.
     */
    private static final String NONE = "";


    /**
     * Main calculator method - get text massive with numbers and the symbol of trigonometric action for execution.
     *
     * @param respond String[] 0 - first number, 1 - arithmetic action, 2 - second number.
     * @return answer of calculation.
     */
    @Override
    public double calculate(String[] respond) {
        double answer = super.calculate(respond);
        if (answer == Double.parseDouble(respond[0])) {
            double first = Double.parseDouble(respond[0]);
            double second = Double.parseDouble(respond[2]);
            switch (respond[1]) {
                case "sin":
                    if (!respond[2].equalsIgnoreCase(NONE)) {
                        answer = sin(second);
                    } else {
                        answer = sin(answer);
                    }
                    break;
                case "cos":
                    if (!respond[2].equalsIgnoreCase(NONE)) {
                        answer = cos(second);
                    } else {
                        answer = cos(answer);
                    }
                    break;
                case "tan":
                    if (!respond[2].equalsIgnoreCase(NONE)) {
                        answer = tan(second);
                    } else {
                        answer = tan(answer);
                    }
                    break;
                default:
                    break;
            }
        }
        return answer;
    }

    /**
     * calculate sinus of argument.
     *
     * @param first value for calculatin.
     * @return sinus of argument.
     */
    private double sin(double first) {
        return Math.sin(first);
    }

    /**
     * calculate cosinus of argument.
     *
     * @param first value for calculatin.
     * @return cosinus of argument.
     */
    private double cos(double first) {
        return Math.cos(first);
    }

    /**
     * calculate tangens of argument.
     *
     * @param first value for calculatin.
     * @return tangens of argument.
     */
    private double tan(double first) {
        return Math.tan(first);
    }
}
