/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import java.util.Properties;

/**
 * Interface InterfaceProperties - load and save properties for game
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 25.02.2020
 */
public interface InterfaceProperties extends LoadProperties, SaveProperties {

    /**
     * Load properties file
     *
     * @param url - name of resource file
     * @return Properties object
     */
    @Override
    default Properties load(String url) {
        return null;
    }

    /**
     * Save changes into properties file
     *
     * @param prop saved file
     * @param url name of resource file
     */
    @Override
    default void save(Properties prop, String url) {

    }
}
