/**
 * Пакет ru.job4j.parking для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.parking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Класс PublicParking - double parking, there is additional storage for lorry or any vehicle with size == 2.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 20.02.20
 */
public class PublicParking<E extends Vehicle> extends Parkings<E> {
    private static final Logger LOG = LogManager.getLogger(PublicParking.class.getName());

    /**
     * additional parking for lorries.
     */
    private Parking<E> truckParking;

    /**
     * constructor for double parking.
     *
     * @param newSize   size of parking for any vehicles
     * @param truckSize size of parking for lorries
     */
    public PublicParking(int newSize, int truckSize) {
        super(newSize);
        truckParking = new Parkings<>(truckSize * 2);
    }

    /**
     * put vehicle to storage, if vehicle is lorry, first try to put in to truckParking.
     *
     * @param vehicle vehicle
     * @return true if operation is succsesfull or false
     */
    @Override
    public boolean in(E vehicle) {
        if (vehicle.getSize() == 2) {
            return truckParking.in(vehicle);
        }
        return super.in(vehicle);
    }

    /**
     * return vehicle from parkung.
     *
     * @param number goverment number of vehicle
     * @return vehicle
     */
    @Override
    public E out(String number) {
        E temp = truckParking.out(number);
        if (temp != null) {
            return temp;
        }
        return super.out(number);
    }

    /**
     * inform about empty spaces into parking.
     *
     * @return quantity of empty spaces
     */
    @Override
    public int getEmprySpace() {
        return super.getEmprySpace() + truckParking.getEmprySpace() / 2;
    }

    /**
     * inform about size of parking.
     *
     * @return size of parking
     */
    @Override
    public int getSize() {
        return super.getSize() + truckParking.getSize() / 2;
    }
}
