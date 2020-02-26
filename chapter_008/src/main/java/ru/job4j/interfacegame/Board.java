/**
 * Package ru.job4j.interfacegame for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.interfacegame;

/**
 * Interface Board - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 26.02.2020
 */
public interface Board {

    /**
     * make actions for making turn
     *
     * @param user who make turn
     * @return true is turn succesfull
     */
    boolean makeTrun(User user);

    /**
     * find position of user on board
     *
     * @param user user
     * @return position of user
     */
    Position findPosition(User user);

    /**
     * execute event accordingly to the position
     *
     * @param user user
     * @return additional info to user status
     */
    String executeEvent(User user);
}
