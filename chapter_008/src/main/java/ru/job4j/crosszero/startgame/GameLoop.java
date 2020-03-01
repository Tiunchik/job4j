/**
 * Package ru.job4j.crosszero.players for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero.startgame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.crosszero.interfaces.IInterpretator;
import ru.job4j.crosszero.interfaces.Interact;
import ru.job4j.crosszero.interfaces.InterfaceBoard;
import ru.job4j.crosszero.interfaces.InterfaceGameLoop;
import ru.job4j.crosszero.interfaces.InterfaceLogic;
import ru.job4j.crosszero.interfaces.InterfacePlayer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class GameLoop.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 29.02.2020
 */
public class GameLoop implements InterfaceGameLoop {
    private static final Logger LOG = LogManager.getLogger(GameLoop.class.getName());
    /**
     * constant with value for exit from option menu.
     */
    private final static String STOP = "exit";

    /**
     * pattern for checking anwers of user.
     */
    private final static String MATCH_PATTERN = "^[1-9]+[=/_\\-][1-9]+$";

    /**
     * board for game.
     */
    private InterfaceBoard board;

    /**
     * composition inner file, associated to board.
     */
    private InterfaceLogic logic;

    /**
     * used to work with players.
     */
    private String answer = "";

    /**
     * contains recognition of answers from users and AI.
     */
    private String[] action = {"__", "__", "__"};

    /**
     * Make one game and return result in String format.
     *
     * @param inter object for interacting with users
     * @param interpret object converts user and AI string answers in acceptable String[] format
     * @param first firts player, can be AI
     * @param second second player, can be AI
     * @param board board for game
     * @return x if winner is X player, O if winner is O player, Draw if there isn't gaps on board
     */
    @Override
    public String makeOneGame(Interact inter, IInterpretator interpret,
                              InterfacePlayer first, InterfacePlayer second, InterfaceBoard board) {
        this.board = board;
        logic = new Logic(board.getBoard());
        Map<String, InterfacePlayer> players = new TreeMap<>(Map.of("X", first, "O", second));
        List<String> playerList = players.keySet()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        inter.informUser("\nLet's start a game!\n");
        board.printBoard(inter);
        while (!answer.equalsIgnoreCase(STOP)) {
            for (var player : playerList) {
                do {
                    do {
                        answer = players.get(player).makeTurn(player);
                    } while (!(answer.equalsIgnoreCase(STOP) || answer.matches(MATCH_PATTERN)));
                    action = interpret.understand(answer);
                } while (!(answer.equalsIgnoreCase(STOP) || board.setTurn(action, player)));
                board.printBoard(inter);
                if (logic.isWinner(player) || logic.hasGap()) {
                    answer = logic.isWinner(player) ? player : "draw";
                    break;
                }
            }
            if (answer.equalsIgnoreCase("X") || answer.equalsIgnoreCase("O")) {
                return answer;
            }
        }
        return answer;
    }

}
