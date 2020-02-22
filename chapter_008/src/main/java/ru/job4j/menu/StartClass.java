/**
 * Menu package.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class StartClass - start class
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since -
 */
public class StartClass {
    private static final Logger LOG = LogManager.getLogger(StartClass.class.getName());

    /**
     * Main
     *
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(0, "root");
        Node one = new Node(1, "one");
        Node two = new Node(2, "two");
        Node three = new Node(3, "three");
        root.leafs.add(one);
        root.leafs.add(two);
        root.leafs.add(three);
        Node oneone = new Node(1, "oneone");
        Node onetwo = new Node(2, "onetwo");
        Node onethree = new Node(3, "onethree");
        one.leafs.add(oneone);
        one.leafs.add(onetwo);
        one.leafs.add(onethree);
        Node onethreeone = new Node(1, "onethreeone");
        onethree.leafs.add(onethreeone);
        new MainLoop().start(new Interaction(), FindChosenPoint.getFinder(root), PrintMenu.getMenu(root));
    }
}
