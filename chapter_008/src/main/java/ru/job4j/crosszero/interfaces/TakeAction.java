/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero.interfaces;

/**
 * Interface TakeAction - executed class, include list of actions.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public interface TakeAction {

    /**
     * execute any actions, use object for interactions and interpitation.
     *
     * @param inter object for interaction with user
     * @param interpret object for understanding user answers
     * @return "next" when finish all actions
     */
    String execute(Interact inter, IInterpretator interpret) throws InterruptedException;

    /**
     * Return name of object.
     *
     * @return name of object
     */
    String showName();
}
