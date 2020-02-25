/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import java.util.Map;

/**
 * Interface InterfaceMenu - show menu that is consisted from TakeAction objects
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public interface InterfaceMenu {

    /**
     * Show list of actions with methods of Interact class
     *
     * @param listOfActions list of actions
     * @param inter class implmented for showing
     */
    void show(Map<String, TakeAction> listOfActions, Interact inter);

}
