/**
 * Package ru.job4j.crosszero.players for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero.interfaces;

/**
 * Interface Board
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 29.02.2020
 */
public interface InterfaceBoard {

    /**
     * return link to board for logic class or others
     *
     * @return board
     */
    public String[][] getBoard();

    /**
     * draw symbol accordingly to coordinates
     *
     * @param xy     coordinates
     * @param symbol symbol for drawing
     * @return true if symbol is drown
     */
    public boolean setTurn(String[] xy, String symbol);

    /**
     * clean all symbols from board and prepare board for game
     */
    public void cleanBoard();

    /**
     * print board to user by methods of inter
     *
     * @param inter class for interactions with user
     */
    public void printBoard(Interact inter);


}
