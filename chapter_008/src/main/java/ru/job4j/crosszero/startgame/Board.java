/**
 * Package ru.job4j.crosszero.players for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero.startgame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.crosszero.interfaces.Interact;
import ru.job4j.crosszero.interfaces.InterfaceBoard;

/**
 * Class Board -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 01.03.2020
 */
public class Board implements InterfaceBoard {
    private static final Logger LOG = LogManager.getLogger(Board.class.getName());

    /**
     * game board.
     */
    private final String[][] board;

    /**
     * size of board.
     */
    private int size;

    /**
     * template to draw empty cells.
     */
    private final String empty = "____";

    /**
     * constructor of board, set size of board.
     *
     * @param size
     */
    public Board(int size) {
        this.size = size;
        this.board = new String[size][size];
        cleanBoard();

    }

    /**
     * return link to board.
     *
     * @return board
     */
    @Override
    public String[][] getBoard() {
        return board;
    }

    /**
     * draw symbol accordingly to coordinates.
     *
     * @param xy     coordinates
     * @param symbol symbol for drawing
     * @return true if symbol is drown
     */
    @Override
    public boolean setTurn(String[] xy, String symbol) {
        int x = Integer.parseInt(xy[0]) - 1;
        int y = Integer.parseInt(xy[2]) - 1;
        if (chechCell(x, y)) {
            board[x][y] = symbol;
            return true;
        }
        return false;
    }

    /**
     * clean all symbols from board.
     */
    @Override
    public void cleanBoard() {
        for (int bigIndx = 0; bigIndx < size; bigIndx++) {
            for (int smIndx = 0; smIndx < size; smIndx++) {
                board[bigIndx][smIndx] = empty;
            }
        }
    }

    /**
     * print board to user by methods of inter.
     *
     * @param inter class for interactions with user
     */
    @Override
    public void printBoard(Interact inter) {
        for (var e : board) {
            for (var i : e) {
                inter.informUser(String.format("|%4s|", i));
            }
            inter.informUser("\n");
        }
    }

    public boolean chechCell(int x, int y) {
        return x < board.length && y < board[x].length && board[x][y].equalsIgnoreCase(empty);
    }
}
