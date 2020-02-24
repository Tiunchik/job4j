/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

/**
 * Interface TakeAction - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public interface TakeAction {

    String execute(Interact inter, IInterpretator interpret);

    String showName();
}
