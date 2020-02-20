/**
 * Пакет ru.job4j.parking для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.parking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Класс Lorry - data model for lory.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 20.02.20
 */
public class Lorry extends Cars {
    private static final Logger LOG = LogManager.getLogger(Lorry.class.getName());

    /**
     * constructor for truck, set size of vehicle additionaly.
     *
     * @param number size of truck
     */
    public Lorry(String number) {
        super(number);
        setSize(2);
    }
}
