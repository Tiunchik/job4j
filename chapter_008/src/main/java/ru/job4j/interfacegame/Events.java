/**
 * Package ru.job4j.interfacegame for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.interfacegame;

/**
 * Interface Events - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 26.02.2020
 */
public interface Events {

    /**
     * Action that implements to user
     *
     * @param user user for action
     * @param position position of user, actions can affect others users on position
     */
    void act(User user, Position position);
}
