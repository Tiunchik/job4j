/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class Deck - class contains game board and methods for it
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public class Deck {
    private static final Logger LOG = LogManager.getLogger(Deck.class.getName());

    /**
     * template to draw empty cells
     */
    private final String empty = "____";

    /**
     * game board
     */
    private String[][] board;

    /**
     * size of board
     */
    private int size;

    /**
     * constructor of board
     *
     * @param size size of board
     */
    public Deck(int size) {
        board = new String[size][size];
        this.size = size;
    }

    /**
     * return link to board
     *
     * @return board
     */
    public String[][] getBoard() {
        return board;
    }

    /**
     * draw symbol accordingly to coordinates
     *
     * @param x row
     * @param y column
     * @param symbol symbol for drawing
     */
    public void setTurn(int x, int y, String symbol) {
        board[x][y] = symbol;
    }

    /**
     * clean all symbols from board
     */
    public void cleanBoard() {
        for (int bigIndx = 0; bigIndx < size; bigIndx++) {
            for (int smIndx = 0; smIndx < size; smIndx++) {
                board[bigIndx][smIndx] = empty;
            }
        }
    }

    /**
     * print board to user by methods of inter
     *
     * @param inter class for interactions with user
     */
    public void printBoard(Interact inter) {
        for (var e : board) {
            for (var i : e) {
                inter.informUser(String.format("|%4s|", i));
            }
            inter.informUser("\n");
        }
    }
}
