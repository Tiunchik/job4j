/**
 * Package ru.job4j.crosszero.players for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero.startgame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.crosszero.interfaces.Interact;
import ru.job4j.crosszero.interfaces.InterfacePlayer;

/**
 * Class AIPlayer.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 01.03.2020
 */
public class AIPlayer implements InterfacePlayer {
    private static final Logger LOG = LogManager.getLogger(AIPlayer.class.getName());

    /**
     * template to draw empty cells.
     */

    private final String empty = "____";

    /**
     * game board.
     */
    private String[][] board;

    /**
     * contains onject with methods for interaction with user.
     */
    private Interact inter;

    /**
     * constructor for AI, take links to board.
     *
     * @param board link to board
     */
    AIPlayer(String[][] board, Interact inter) {
        this.board = board;
        this.inter = inter;
    }

    /**
     * Make actions with board, return symbol for next methods.
     *
     * @param symbol symbol of player
     * @return return set symbol
     */
    @Override
    public String makeTurn(String symbol) {
        inter.informUser("Turn of PC-games\n");
        try {
            inter.informUser("PC is thinking...\n");
            Thread.sleep(500);
            inter.informUser("PC is thinking...\n");
            Thread.sleep(500);
            inter.informUser("And finally!\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int size = board.length;
        for (int bigIndx = 0; bigIndx < size; bigIndx++) {
            for (int smIndx = 0; smIndx < size; smIndx++) {
                if (board[bigIndx][smIndx].equalsIgnoreCase(empty)) {
                    symbol = (bigIndx + 1) + "-" + (smIndx + 1);
                    return symbol;
                }
            }
        }
        return symbol;
    }
}
