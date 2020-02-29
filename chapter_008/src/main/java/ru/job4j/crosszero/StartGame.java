/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

/**
 * Class StartGame - start and execute full circle of game according properties
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public class StartGame implements TakeAction {
    private static final Logger LOG = LogManager.getLogger(StartGame.class.getName());

    /**
     * constant with value for exit from option menu
     */
    private final static String STOP = "exit";

    /**
     * start and execute full circle of game according properties
     *
     * @param inter object for interaction with user
     * @param interpret object for understanding user answers
     * @return "next" when finish all actions
     */
    @Override
    public String execute(Interact inter, IInterpretator interpret) {
        Config cong = new Config("game.properties");
        Properties prop = cong.load("game.properties");
        int games = Integer.parseInt((String) prop.get("games"));
        int first = 0;
        int second = 0;
        InterfaceGame game = new OneGame(inter, interpret, prop);
        while (games >= (first + second)) {
            String conclus = game.playGame();
            if (conclus.equalsIgnoreCase("x")) {
                first++;
            }
            if (conclus.equalsIgnoreCase("o")) {
                second++;
            }
            if (conclus.equalsIgnoreCase(STOP)) {
                break;
            }
        }
        if (first > second) {
            inter.informUser("Set of games have been winned by the X player\n");
        } else {
            inter.informUser("Set of games have been winned by the O player\n");
        }
        return "next";
    }

    /**
     * Return name of object
     *
     * @return name of object
     */
    @Override
    public String showName() {
        return "Start game";
    }


}
