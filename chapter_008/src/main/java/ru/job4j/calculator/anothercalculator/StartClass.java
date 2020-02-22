/**
 * Calculator package.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.calculator.anothercalculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс StartClass - main loop and actions.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 22.02.2020
 */
public class StartClass {
    /**
     * inner logger.
     */
    private static final Logger LOG = LogManager.getLogger(StartClass.class.getName());

    /**
     * Start execution of programm.
     *
     * @param args - not used, arguments from command line.
     */
    public static void main(String[] args) {
        Map<String, Compute> actions = new HashMap<>();
        actions.put("+", new Add());
        actions.put("-", new Subtract());
        actions.put("*", new Multiply());
        actions.put("/", new Div());
        actions.put("cos", new Cos());
        actions.put("sin", new Sin());
        actions.put("tan", new Tan());
        new MainLoop().start(new Interaction(), new Interpritator(), actions);
    }
}
