/**
 * Menu package.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Map;

/**
 * Class MainLoop - main programm loop, work with user, start methods.
 *
 * @author Maksim Tiunchik (senebh@gmail.com).
 * @version 0.1.
 * @since 17.02.2020.
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
     * main loop of programm
     *
     * @param interact        class responsible for interactions with user
     * @param findChosenPoint class for understanding ser answers
     * @param menu            class for print menu from nods
     */
    public void start(Interact interact, Find findChosenPoint, Print menu) {
        String answer = "";
        while (!answer.equals(STOP)) {
            menu.print();
            answer = interact.askUser("Please write request:");
            Node temp = findChosenPoint.find(answer);
            if (temp != null) {
                interact.informUser(temp.name);
            }
        }
    }
}
