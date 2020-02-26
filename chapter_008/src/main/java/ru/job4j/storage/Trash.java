/**
 * Пакет ru.job4j.storage для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Класс Trash -  - class storage for data model Food.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.02.20.
 */
public class Trash extends FoodStorage {
    private static final Logger LOG = LogManager.getLogger(Trash.class.getName());

    @Override
    public boolean accept(double dbl) {
        return dbl >= 1;
    }
}
