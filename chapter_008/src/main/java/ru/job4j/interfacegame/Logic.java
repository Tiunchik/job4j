/**
 * Package ru.job4j.interfacegame for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.interfacegame;

/**
 * Interface Logic - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 26.02.2020
 */
public interface Logic {

    /**
     * check this user is winner or not
     *
     * @param user - user for check
     * @return true if user is winner or false
     */
    boolean isWin(User user, Position position);

    /**
     * check is there have to be execute events action, use status of position
     *
     * @param user - actions implements to this user
     * @param position position of user
     * @return tru is action have to be execute
     */
    boolean isEvent(User user, Position position);
}
