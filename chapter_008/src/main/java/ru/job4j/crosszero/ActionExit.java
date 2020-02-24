/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class ActionExit - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public class ActionExit implements  TakeAction {
    private static final Logger LOG = LogManager.getLogger(ActionExit.class.getName());

    @Override
    public String execute(Interact inter, IInterpretator interpret) {
        return "by";
    }

    @Override
    public String showName() {
        return "Exit";
    }
}
