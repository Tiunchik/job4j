/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * Class MainLoop -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public class MainLoop implements InterMainLoop {
    private static final Logger LOG = LogManager.getLogger(MainLoop.class.getName());

    private final static String STOP = "exit";

    @Override
    public void init(Interact inter, IInterpretator interpret, InterfaceMenu menu, Map<String, TakeAction> listActions) {
        String answer = "";
        while (!answer.equalsIgnoreCase(STOP)) {
            menu.show(listActions, inter);
            answer = inter.askUser("Please, choose point of menu, or fill out EXIT to exit\n");
            TakeAction temp = listActions.get(answer);
            if (temp != null) {
                answer = listActions.get(answer).execute(inter, interpret);
            }
        }
    }
}
