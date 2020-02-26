/**
 * Package ru.job4j.menu for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.menu;

/**
 * Interface Loop - main programm loop, work with user, start methods.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 26.02.2020
 */
public interface Loop {

    /**
     * main loop of programm
     *
     * @param interact        class responsible for interactions with user
     * @param findChosenPoint class for understanding ser answers
     * @param menu            class for print menu from nods
     */
    void start(Interact interact, Find findChosenPoint, Print menu);
}
