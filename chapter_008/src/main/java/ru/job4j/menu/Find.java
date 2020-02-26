/**
 * Menu package.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.menu;

/**
 * Interface Find - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 26.02.2020
 */
public interface Find {

    /**
     * Find node according user request
     *
     * @param key user request
     * @return Node for this request
     */
    Node find(String key);


}
