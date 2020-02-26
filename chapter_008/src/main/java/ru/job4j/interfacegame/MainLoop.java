/**
 * Package ru.job4j.interfacegame for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.interfacegame;

import java.util.Map;

/**
 * Interface MainLoop - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 26.02.2020
 */
public interface MainLoop {

    /**
     * Start game, add boad and map of users
     *
     * @param board board for game
     * @param list map of users
     */
    void startGame(Board board, Map<String, User> list);
}
