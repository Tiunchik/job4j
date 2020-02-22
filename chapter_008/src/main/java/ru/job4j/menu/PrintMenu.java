/**
 * Menu package.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

/**
 * Class PrintMenu - print menu
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since -
 */
public class PrintMenu {
    private static final Logger LOG = LogManager.getLogger(PrintMenu.class.getName());

    /**
     * start Node of menu
     */
    private Node root;

    /**
     * Constructor of menu class, set start node
     *
     * @param root start node of menu
     */
    private PrintMenu(Node root) {
        this.root = root;
    }

    /**
     * Static class to get PrintMenu example
     *
     * @param root start node of menu
     * @return PrintMenu example
     */
    public static PrintMenu getMenu(Node root) {
        return new PrintMenu(root);
    }

    /**
     * Print menu
     */
    public void print() {
        for (var e : root.leafs) {
            System.out.printf("%s Задача %s %s \n", "---", e.number + ".", e.name);
            innerPrint(e, "--", e.number + ".");
        }


    }

    /**
     * Print leafs of Node
     *
     * @param node Node which leafs are printed
     * @param inTab tab
     * @param number position
     */
    private void innerPrint(Node node, String inTab, String number) {
        inTab = inTab + "---";
        for (var e : node.leafs) {
            String outNum = number +  e.number + ".";
            System.out.printf("%s Задача %s %s \n", inTab, outNum, e.name);
            innerPrint(e, inTab, outNum);
        }
    }
}
