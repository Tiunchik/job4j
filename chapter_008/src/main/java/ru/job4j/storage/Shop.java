/**
 * Пакет ru.job4j.storage для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Класс Shop - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since -
 */
public class Shop extends FoodStorage {
    private static final Logger LOG = LogManager.getLogger(Shop.class.getName());


    @Override
    public void push(Food t) {
        super.push(t);
    }

    @Override
    public boolean accept(double dbl) {
        return dbl > 0.25 && dbl < 1.0;
    }
}
