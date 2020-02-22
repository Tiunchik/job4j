/**
 * Пакет ru.job4j.calculator.anothercalculator для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.calculator.anothercalculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Класс Add -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since -
 */
public class Subtract implements Compute {
    private static final Logger LOG = LogManager.getLogger(Subtract.class.getName());

    @Override
    public double calculate(String[] arguments) {
        double first = Double.parseDouble(arguments[0]);
        double second = Double.parseDouble(arguments[2]);
        double answer = first;
        answer = new Calculator().subtract(first, second);
        return answer;
    }

}
