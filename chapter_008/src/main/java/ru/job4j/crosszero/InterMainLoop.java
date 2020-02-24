/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import java.util.Map;

/**
 * Interface InterMainLoop - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public interface InterMainLoop {

        void init(Interact inter, IInterpretator interpret, InterfaceMenu menu,  Map<String, TakeAction> listActions);
}
