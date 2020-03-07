/**
 * Package ru.job4j.design for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.design;

import java.util.List;
import java.util.function.Predicate;


/**
 * Interface Store - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.03.2020
 */
public interface Store {

    /**
     * retuns lisf of employers that match filter
     *
     * @param filter retuns lisf of employers that match filter
     * @return
     */
    List<Employer> findBy(Predicate<Employer> filter);
}