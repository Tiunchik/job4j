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
public class Cos implements Compute {
    private static final Logger LOG = LogManager.getLogger(Cos.class.getName());

    @Override
    public double calculate(double first, double second) {
        double answer = first;
        answer = new Calculator().cos(second);
        return answer;
    }

}
