/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.crosszero.interfaces.*;

import java.util.Map;

/**
 * Class MainLoop - main menu loop
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public class MainLoop implements InterMainLoop {
    private static final Logger LOG = LogManager.getLogger(MainLoop.class.getName());
    /**
     * constant with value for exit from menu
     */
    private final static String STOP = "exit";

    /**
     * Start programm
     *
     * @param inter class for sending messages
     * @param interpret class for recognition answers from user
     * @param menu class to show menu
     * @param listActions options for menu
     */
    @Override
    public void init(Interact inter, IInterpretator interpret, InterfaceMenu menu, Map<String, TakeAction> listActions)  {
        String answer = "";
        while (!answer.equalsIgnoreCase(STOP)) {
            menu.show(listActions, inter);
            answer = inter.askUser("Please, choose point of menu, or fill out EXIT to exit\n");
            TakeAction temp = listActions.get(answer);
            if (temp != null) {
                try {
                answer = listActions.get(answer).execute(inter, interpret);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
