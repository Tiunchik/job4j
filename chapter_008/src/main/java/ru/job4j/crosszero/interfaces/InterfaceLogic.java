/**
 * Package ru.job4j.crosszero.players for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero.interfaces;

/**
 * Interface Logic - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 29.02.2020
 */
public interface InterfaceLogic {

    /**
     * views all possibile lines and determines winner
     *
     * @param symbol - symbol of winner
     * @return true if symbol holder is win or false
     */
    boolean isWinner(String symbol);

    /**
     * check is there an empty cell into board
     *
     * @return true if board contains free cells or false
     */
    boolean hasGap();

}
