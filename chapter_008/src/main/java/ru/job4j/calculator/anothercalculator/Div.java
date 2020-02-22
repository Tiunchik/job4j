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
public class Div implements Compute {
    private static final Logger LOG = LogManager.getLogger(Div.class.getName());

    @Override
    public double calculate(double first, double second) {
        double answer = first;
        answer = new Calculator().div(first, second);
        return answer;
    }

}
