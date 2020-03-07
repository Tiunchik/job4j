/**
 * Package ru.job4j.design for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.design;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class MemStore -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.03.2020
 */
public class MemStore implements Store {

    /**
     * inner array list for keeping emploers
     */
    private final List<Employer> employers = new ArrayList<>();

    /**
     * add Employer to Store
     *
     * @param em employer
     */
    public void add(Employer em) {
        employers.add(em);
    }

    /**
     * retuns lisf of employers that match filter
     *
     * @param filter retuns lisf of employers that match filter
     * @return
     */
    @Override
    public List<Employer> findBy(Predicate<Employer> filter) {
        return employers.stream().filter(filter).collect(Collectors.toList());
    }
}