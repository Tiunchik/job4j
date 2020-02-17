/**
 * Calculator package
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Класс StartClass - main loop and actions.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 17.02.2020
 */
public class StartClass {
    /**
     * inner logger
     */
    private static final Logger LOG = LogManager.getLogger(StartClass.class.getName());

    /**
     * Start execution of programm.
     *
     * @param args - not used, arguments from command line
     */
    public static void main(String[] args) {
        new MainLoop().start(new Interaction(), new Interpritator(), new Calculator());
    }
}
