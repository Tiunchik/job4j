/**
 * Menu package.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.menu;

/**
 * Interface Interact - ask and inform user
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public interface Interact {

    /**
     * Send message to user
     *
     * @param inform text of message
     */
    void informUser(String inform);

    /**
     * Send message to user and get respond from they
     *
     * @param question text of message
     * @return respond of user
     */
    String askUser(String question);

}
