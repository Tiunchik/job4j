/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class ConsistentAI - pretends AI
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 25.02.2020
 */
public class ConsistentAI implements AIactions {
    private static final Logger LOG = LogManager.getLogger(ConsistentAI.class.getName());
    /**
     * consist link to game board
     */
    private String[][] board;

    /**
     * template to find empty cells
     */
    private final String empty = "____";

    /**
     * constructor for AI, take links to board
     *
     * @param board link to board
     */
    ConsistentAI(String[][] board) {
        this.board = board;
    }

    /**
     * Make actions with board, return symbol "O" for next methods
     *
     * @return return symbol "O"
     */
    @Override
    public String aiturn() {
        var nonStop = true;
        int size = board.length;
        for (int bigIndx = 0; bigIndx < size; bigIndx++) {
            for (int smIndx = 0; smIndx < size; smIndx++) {
                if (board[bigIndx][smIndx].equalsIgnoreCase(empty) && nonStop) {
                    board[bigIndx][smIndx] = "O";
                    nonStop = false;
                    break;
                }
            }
        }
        return "O";
    }
}
