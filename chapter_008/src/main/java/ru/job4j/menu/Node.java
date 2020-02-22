/**
 * Menu package.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Node - model of data
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 22.02.20
 */
public class Node {
    private static final Logger LOG = LogManager.getLogger(Node.class.getName());

    /**
     * number of node
     */
    int number;
    /**
     * name of node
     */
    String name;
    /**
     * list of leafs
     */
    List<Node> leafs = new ArrayList<>();

    /**
     * constructor for Node
     *
     * @param number number of position
     * @param name name of Node
     */
    Node(int number, String name) {
        this.number = number;
        this.name = name;
    }
}
