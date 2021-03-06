/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero.interfaces;

import java.util.Properties;

/**
 * Interface LoadProperties - load properties for game.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public interface LoadProperties {

    /**
     * Load properties file.
     *
     * @param url - name of resource file
     * @return Properties object
     */
    Properties load(String url);
}
