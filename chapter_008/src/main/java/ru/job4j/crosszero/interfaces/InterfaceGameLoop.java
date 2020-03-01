/**
 * Package ru.job4j.crosszero.players for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero.interfaces;

/**
 * Interface GemaLoop - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 29.02.2020
 */
public interface InterfaceGameLoop {

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
    String makeOneGame(Interact inter,
                       IInterpretator interpret,
                       InterfacePlayer first,
                       InterfacePlayer second,
                       InterfaceBoard board);

}
