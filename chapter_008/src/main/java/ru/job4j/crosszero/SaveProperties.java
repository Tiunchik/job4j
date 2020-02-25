/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import java.util.Properties;

/**
 * Interface SaveProperties - save properties for game
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public interface SaveProperties {

    /**
     * Save changes into properties file
     *
     * @param prop saved file
     * @param url name of resource file
     */
    void save(Properties prop, String url);
}
