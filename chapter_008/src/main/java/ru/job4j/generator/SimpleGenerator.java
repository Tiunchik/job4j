/**
 * Package ru.job4j.generator for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.generator;

import java.util.Map;

/**
 * Interface SimpleGenerator - implements method for work with paterns and regex
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 23.02.2020
 */
public interface SimpleGenerator {

    String terminate(String template, Map<String, String> keys) throws KeyException;

}
