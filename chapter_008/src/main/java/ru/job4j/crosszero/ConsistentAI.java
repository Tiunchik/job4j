/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class ConsistentAI -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 25.02.2020
 */
public class ConsistentAI implements AIactions {
    private static final Logger LOG = LogManager.getLogger(ConsistentAI.class.getName());

    private String[][] board;
    private final String empty = "____";

    ConsistentAI(String[][] board) {
        this.board = board;
    }

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
