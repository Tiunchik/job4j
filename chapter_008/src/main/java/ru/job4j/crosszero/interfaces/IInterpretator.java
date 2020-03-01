/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero.interfaces;

/**
 * Interface IInterpretator - interface for methods for understanding user answers.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public interface IInterpretator {

    /**
     * Take answer of user and return sorted accordingly RegExp array String.
     *
     * @param answer any text
     * @return special prepared array, or array {"__","__","__"}
     */
    String[] understand(String answer);

}
