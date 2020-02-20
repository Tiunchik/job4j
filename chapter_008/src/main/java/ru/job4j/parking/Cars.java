/**
 * Пакет ru.job4j.parking для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.parking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Класс Cars - asbtract class for data model.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 20.02.20
 */
public abstract class Cars implements Vehicle {
    private static final Logger LOG = LogManager.getLogger(Cars.class.getName());
    /**
     * Name of brand or goverment number of car.
     */
    private String number;
    /**
     * size of vehicle.
     */
    private int size;

    /**
     * constructor for Cars, set number of vehicle.
     *
     * @param number
     */
    public Cars(String number) {
        this.number = number;
    }

    /**
     * getter for number.
     *
     * @return number
     */
    @Override
    public String getNumber() {
        return number;
    }

    /**
     * setter for number.
     *
     * @param number argument for number
     */
    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * getter for size.
     *
     * @return number
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * setter for size.
     *
     * @param size argument for size
     */
    @Override
    public void setSize(int size) {
        this.size = size;
    }
}
