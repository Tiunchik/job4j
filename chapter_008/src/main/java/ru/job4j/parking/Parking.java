/**
 * Пакет ru.job4j.parking для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.parking;

/**
 * Интерфейс Parking - interface for vehicle storage.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 20.02.20
 */
public interface Parking<E extends Vehicle> {

    /**
     * put vehicle to storage.
     *
     * @param e vehicle
     * @return true if operation is succsesfull or false
     */
    boolean in(E e);

    /**
     * return vehicle from parkung.
     *
     * @param number goverment number of vehicle
     * @return vehicle
     */
    E out(String number);

    /**
     * inform about empty spaces into parking.
     *
     * @return quantity of empty spaces
     */
    int getEmprySpace();

    /**
     * inform about size of parking.
     *
     * @return size of parking
     */
    int getSize();
}
