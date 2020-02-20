/**
 * Пакет ru.job4j.parking для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.parking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс Parkings - parking for any tape of vehicle.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 20.02.20
 */
public class Parkings<E extends Vehicle> implements Parking<E> {
    private static final Logger LOG = LogManager.getLogger(Parkings.class.getName());

    /**
     * Map where link to vehicle stored.
     */
    private Map<String, E> base = new HashMap<>();
    /**
     * Parking places.
     */
    private String[] parkingSpaces;
    /**
     * size of parking.
     */
    private int size;
    /**
     * empty spaces on parking.
     */
    private int emptySize;

    /**
     * constructor for parking, set quantity of empty spaces.
     *
     * @param newSize quantity of empty spaces
     */
    public Parkings(int newSize) {
        parkingSpaces = new String[newSize];
        size = newSize;
        emptySize = newSize;
    }

    /**
     * put vehicle to storage.
     *
     * @param e vehicle
     * @return true if operation is succsesfull or false
     */
    @Override
    public boolean in(E e) {
        int tempSize = e.getSize();
        int[] findSpace = new int[tempSize];
        int index = 0;
        int findIndex = 0;
        for (var i : parkingSpaces) {
            if (i == null) {
                if (findIndex > 0 && findSpace[findIndex - 1] != index - 1) {
                    findIndex = 0;
                    findSpace = new int[tempSize];
                }
                findSpace[findIndex++] = index;
                if (findIndex == tempSize) {
                    break;
                }
            }
            index++;
        }
        index = 0;
        var answer = true;
        for (var i : findSpace) {
            if (index != 0) {
                if (findSpace[index] == findSpace[index - 1]) {
                    answer = false;
                }
            }
            index++;
        }
        if (answer) {
            for (var i : findSpace) {
                parkingSpaces[i] = e.getNumber();
            }
            base.put(e.getNumber(), e);
            emptySize = emptySize - findSpace.length;
        }
        return answer;
    }

    /**
     * return vehicle from parkung.
     *
     * @param number goverment number of vehicle
     * @return vehicle
     */
    @Override
    public E out(String number) {
        E answer = base.get(number);
        if (answer != null) {
            String erase = answer.getNumber();
            int index = 0;
            for (var i : parkingSpaces) {
                if (i != null && i.equalsIgnoreCase(erase)) {
                    parkingSpaces[index++] = null;
                }
            }
            emptySize = emptySize + answer.getSize();
        }
        return answer;
    }

    /**
     * inform about empty spaces into parking.
     *
     * @return quantity of empty spaces
     */
    @Override
    public int getEmprySpace() {
        return emptySize;
    }

    /**
     * inform about size of parking.
     *
     * @return size of parking
     */
    @Override
    public int getSize() {
        return size;
    }
}
