/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero.options;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.crosszero.interfaces.IInterpretator;
import ru.job4j.crosszero.interfaces.Interact;
import ru.job4j.crosszero.interfaces.InterfaceProperties;
import ru.job4j.crosszero.interfaces.TakeAction;

import java.util.Properties;

/**
 * Class ChangeOptionsAction - load properies file, show properties for game, properties.
 * can be changed and changes can be saved
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public class ChangeOptionsAction implements TakeAction {
    private static final Logger LOG = LogManager.getLogger(ChangeOptionsAction.class.getName());
    /**
     * constant with value for exit from option menu.
     */
    private static final String STOP = "exit";

    /**
     * load properies file, show properties for game, properties can be changed and changes can be saved.
     *
     * @param inter object for interaction with user
     * @param interpret object for understanding user answers
     * @return "next" when finish all actions
     */
    @Override
    public String execute(Interact inter, IInterpretator interpret) {
        InterfaceProperties loader = new Config("game.properties");
        String answer = "";
        String[] changes;
        Properties prop = loader.load("game.properties");
        while (!answer.equalsIgnoreCase(STOP)) {
            for (var e : prop.keySet()) {
                inter.informUser(String.format("%5s = %s\n", e, prop.get(e)));
            }
            inter.informUser("for exiting to main menu please fill out \"exit\"\n");
            answer = inter.askUser("Please, make changes in options "
                    + "by writing \"name of options = new value\" \n");
            changes = interpret.understand(answer);
            if (prop.containsKey(changes[0].replaceAll(" ", ""))) {
                prop.setProperty(changes[0].replaceAll(" ", ""), changes[2].replaceAll(" ", ""));
            }
        }
        loader.save(prop, "game.properties");
        return "next";
    }

    /**
     * Return name of object.
     *
     * @return name of object
     */
    @Override
    public String showName() {
        return "Change options";
    }
}
