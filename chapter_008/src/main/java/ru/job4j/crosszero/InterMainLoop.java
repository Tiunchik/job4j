/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import java.util.Map;

/**
 * Interface InterMainLoop - main loop of menu
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public interface InterMainLoop {


        /**
         * Start programm
         *
         * @param inter class for sending messages
         * @param interpret class for recognition answers from user
         * @param menu class to show menu
         * @param listActions options for menu
         */
        void init(Interact inter, IInterpretator interpret, InterfaceMenu menu,  Map<String, TakeAction> listActions);
}
