/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Class StartClass - start programm
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public class StartClass {
    private static final Logger LOG = LogManager.getLogger(StartClass.class.getName());

    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {
        Map<String, TakeAction> temp = new HashMap<>();
        temp.put("1", new StartGame());
        temp.put("2", new ChangeOptionsAction());
        temp.put("3", new ActionExit());
        new MainLoop().init(new Interaction(), new Interpritator(), new MenuList(), temp);
    }
}
