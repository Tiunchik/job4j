/**
 * Package ru.job4j.interfacegame for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.interfacegame;

/**
 * Interface User - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 26.02.2020
 */
public interface User {

    /**
     * add information of user status
     *
     * @param text text for adding
     */
    void setStatus(String text);

    /**
     * return information about user
     *
     * @return information about user
     */
    String setStatus();

    /**
     * roll Dice added ro user, return result
     *
     * @return return result of dice
     */
    int rollDice();
}
