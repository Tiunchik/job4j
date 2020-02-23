/**
 * Package ru.job4j.generator for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.generator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class KeyException - exception that occur if map don't have keys for simplegenerator pattern
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 23.02.2020
 */
public class KeyException extends Exception {

    /**
     * Constructor for KeyException, pass messange to super class onstructor
     *
     * @param message
     */
    public KeyException(String message) {
        super(message);
    }
}
