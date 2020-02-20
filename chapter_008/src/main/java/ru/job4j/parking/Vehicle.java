/**
 * Пакет ru.job4j.parking для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.parking;

/**
 * Интерфейс Vehicle - interface of data model.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 20.02.20
 */
public interface Vehicle {

    /**
     * getter for number.
     *
     * @return number
     */
    String getNumber();

    /**
     * setter for number.
     *
     * @param number argument for number
     */
    void setNumber(String number);

    /**
     * getter for size.
     *
     * @return number
     */
    int getSize();

    /**
     * setter for size.
     *
     * @param size argument for size
     */
    void setSize(int size);
}
