/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class MenuList - show menu that is consisted from TakeAction objects
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public class MenuList implements InterfaceMenu {
    private static final Logger LOG = LogManager.getLogger(MenuList.class.getName());

    /**
     * Show list of actions with methods of Interact class
     *
     * @param listOfActions list of actions
     * @param inter class implmented for showing
     */
    @Override
    public void show(Map<String, TakeAction> listOfActions, Interact inter) {
        Set<String> temp = new TreeSet<>(listOfActions.keySet());
        temp = temp.stream().sorted().collect(Collectors.toSet());
        for (var e: temp) {
            inter.informUser(String.format("%5s - %s", e, listOfActions.get(e).showName()));
            inter.informUser("\n");
        }
    }
}
