/**
 * Пакет ru.job4j.storage для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

/**
 * Класс Bread - model of data
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.02.20
 */
public class Bread extends Food {
    private static final Logger LOG = LogManager.getLogger(Bread.class.getName());

    public Bread(String name, Date expaired, Date created, double price, double disscount) {
        super(name, expaired, created, price, disscount);
    }
}
