/**
 * Пакет ru.job4j.storage для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.storage;

/**
 * Интерфейс Storage  - interface storage for data model Food.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.02.20.
 */
public interface Storage {

    /**
     * get and remove T from base
     *
     * @return T from base
     */
    Food get();

    /**
     * push T to base list
     *
     * @param t pushed argument
     */
    void push(Food t);

    /**
     * check is there any T into base
     *
     * @return true or false
     */
    boolean hasNext();

    /**
     * check this food acceptable for this storage, or not
     *
     * @param dbl - % of expiring
     * @return
     */
    boolean accept(double dbl);
}
