/**
 * Пакет ru.job4j.list для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.Date;

/**
 * Класс Warehouse - class storage for data model Food.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.02.2020
 */
public class Warehouse extends FoodStorage {
    private static final Logger LOG = LogManager.getLogger(Warehouse.class.getName());

    @Override
    public boolean accept(double dbl) {
        return dbl < 0.25;
    }
}


