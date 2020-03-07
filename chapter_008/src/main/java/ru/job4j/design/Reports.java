/**
 * Package ru.job4j.design for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.design;

import java.util.function.Predicate;

/**
 * Interface Reports - interface for practical application different reports for different departments.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.03.2020
 */
public interface Reports {

    /**
     * generate report accordingly requirements of departament.
     *
     * @param filter filter to make list of emploers
     * @return text of report
     */
    String generate(Predicate<Employer> filter);

}
