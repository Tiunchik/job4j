/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class Deck -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public class Deck {
    private static final Logger LOG = LogManager.getLogger(Deck.class.getName());

    private final String empty = "____";
    private String[][] board;
    private int size;

    public Deck(int size) {
        board = new String[size][size];
        this.size = size;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setTurn(int x, int y, String symbol) {
        board[x][y] = symbol;
    }

    public void cleanBoard() {
        for (int bigIndx = 0; bigIndx < size; bigIndx++) {
            for (int smIndx = 0; smIndx < size; smIndx++) {
                board[bigIndx][smIndx] = empty;
            }
        }
    }

    public void printBoard(Interact inter) {
        for (var e : board) {
            for (var i : e) {
                inter.informUser(String.format("|%4s|", i));
            }
            inter.informUser("\n");
        }
    }
}
