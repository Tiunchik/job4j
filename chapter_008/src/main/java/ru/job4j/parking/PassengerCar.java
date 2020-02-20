/**
 * Пакет ru.job4j.parking для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.parking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Класс PassengerCar - data model for passenger car.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 20.02.20
 */
public class PassengerCar extends Cars {
    private static final Logger LOG = LogManager.getLogger(PassengerCar.class.getName());


    /**
     * constructor for Passenger Car, set size of vehicle additionaly.
     *
     * @param number size of Passenger Car
     */
    public PassengerCar(String number) {
        super(number);
        setSize(1);
    }
}
