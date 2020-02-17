/**
 * Calculator package
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Класс MainLoop - main programm loop, work with user, start methods.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 17.02.2020
 */
public class MainLoop {
    /**
     * inner logger.
     */
    private static final Logger LOG = LogManager.getLogger(MainLoop.class.getName());

    /**
     * constant for stopping execution.
     */
    private static final String STOP = "by";

    /**
     * main loop of programm.
     *
     * @param interact  class with methods for interactions
     * @param interprit class with methods for interpritation string to dounle
     * @param calc      class with methods for calculations
     */
    public void start(Interaction interact, Interpritator interprit, Calculator calc) {
        double lastresult = 0.0;
        String answer = "";
        String[] after;
        while (!answer.equals(STOP)) {
            answer = interact.askUser("Please write arithmetic expression:");
            after = interprit.understand(answer);
            if (after != null) {
                if (after[0].equals("")) {
                    after[0] = "" + lastresult;
                }
                lastresult = calc.calculate(after);
            }
            interact.informUser(String.format("%-30s %10f", "Result of arithmetic action", lastresult));
        }
    }
}
