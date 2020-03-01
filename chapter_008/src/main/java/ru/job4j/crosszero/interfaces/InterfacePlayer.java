/**
 * Package ru.job4j.crosszero.players for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero.interfaces;

/**
 * Interface Player - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 29.02.2020
 */
public interface InterfacePlayer {

    /**
     * player make turn.
     *
     * @param symbol symbol of player
     * @return sttment like 1-1 or othres, that point on position on board
     */
    String makeTurn(String symbol);

}
