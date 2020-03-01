/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero.startgame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.crosszero.interfaces.IInterpretator;
import ru.job4j.crosszero.interfaces.Interact;
import ru.job4j.crosszero.interfaces.TakeAction;
import ru.job4j.crosszero.interfaces.InterfaceBoard;
import ru.job4j.crosszero.interfaces.InterfaceGameLoop;
import ru.job4j.crosszero.interfaces.InterfacePlayer;
import ru.job4j.crosszero.options.Config;

import java.util.Properties;

/**
 * Class StartGame - start and execute full circle of game according properties.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 01.03.2020
 */
public class StartGame implements TakeAction {
    private static final Logger LOG = LogManager.getLogger(StartGame.class.getName());

    /**
     * constant with value for exit from option menu.
     */
    private final static String STOP = "exit";

    /**
     * main class for execution of game.
     */
    private InterfaceGameLoop game = new GameLoop();

    /**
     * object board for game.
     */
    private InterfaceBoard board;

    /**
     * start and execute full circle of game according properties.
     *
     * @param inter     object for interaction with user
     * @param interpret object for understanding user answers
     * @return "next" when finish all actions
     */
    @Override
    public String execute(Interact inter, IInterpretator interpret) throws InterruptedException {
        Properties prop = new Config("game.properties").load("game.properties");
        board = new Board(Integer.parseInt(prop.getProperty("size")));
        int first = 0, second = 0;
        int games = Integer.parseInt((String) prop.get("games"));
        InterfacePlayer[] players = setPlayers(prop, board, inter);
        while (games >= (first + second)) {
            String conclus = game.makeOneGame(inter, interpret, players[0], players[1], board);
            if (conclus.equalsIgnoreCase("x") || conclus.equalsIgnoreCase("o")) {
                first++;
                Thread.sleep(500);
                inter.informUser(String.format("This game have been winned by the %s player\n", conclus));
            }
            if (conclus.equalsIgnoreCase(STOP)) {
                break;
            }
        }
        Thread.sleep(500);
        if (first > second) {
            inter.informUser("Set of games have been winned by the X player\n");
        } else {
            inter.informUser("Set of games have been winned by the O player\n");
        }
        return "next";
    }

    /**
     * Return name of object.
     *
     * @return name of object
     */
    @Override
    public String showName() {
        return "Start game";
    }

    /**
     * Set players for game.
     *
     * @param prop  properties. according it will be set players
     * @param board link to board for AI player
     * @param inter link to interactions methods for real player
     * @return array of players
     */
    private InterfacePlayer[] setPlayers(Properties prop, InterfaceBoard board, Interact inter) {
        InterfacePlayer[] answer = new InterfacePlayer[2];
        answer[0] = prop.get("aix").equals("null") ? new RealPlayer(inter) : new AIPlayer(board.getBoard(), inter);
        answer[1] = prop.get("aio").equals("null") ? new RealPlayer(inter) : new AIPlayer(board.getBoard(), inter);
        return answer;
    }

}
