/**
 * Menu package.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Class FindChosenPoint - understand user answer
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 22.02.2020
 */
public class FindChosenPoint {
    private static final Logger LOG = LogManager.getLogger(FindChosenPoint.class.getName());

    /**
     * start Node of menu
     */
    private Node root;

    /**
     * Constructor of FindChosenPoint class, set start node
     *
     * @param root start node of menu
     */
    private FindChosenPoint(Node root) {
        this.root = root;
    }

    /**
     * Static class to get FindChosenPoint example
     *
     * @param root start node of menu
     * @return FindChosenPoint example
     */
    public static FindChosenPoint getFinder(Node root) {
        return new FindChosenPoint(root);
    }


    /**
     * Find node according user request
     *
     * @param key user request
     * @return Node for this request
     */
    public Node find(String key) {
        Queue<String> queue = new LinkedList<>();
        char[] temp = key.toCharArray();
        String test = "";
        for (var e : temp) {
            test = "" + e;
            if (!test.matches("[0-9.]*")) {
                return null;
            }
            if (test.matches("[0-9]*")) {
                queue.add(test);
            }
        }
        Node current = root;
        while (!queue.isEmpty()) {
            int currentNum = Integer.parseInt(queue.poll());
            for (var e : current.leafs) {
                if (e.number == currentNum) {
                    current = e;
                }
            }
        }
        return current;
    }
}