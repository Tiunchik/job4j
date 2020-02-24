/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import java.util.Properties;

/**
 * Interface InterfaceProperties -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 25.02.2020
 */
public interface InterfaceProperties extends LoadProperties, SaveProperties {

    @Override
    default Properties load(String url) {
        return null;
    }

    @Override
    default void save(Properties prop, String url) {

    }
}
