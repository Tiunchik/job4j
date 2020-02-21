/**
 * Пакет ru.job4j.storage для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.Date;

/**
 * Класс PutToShop - one of actions for preparation of Food
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 21.02.2020
 */
public class PutToWarehouseWithDis<E extends Food> implements TakeAction<E> {
    private static final Logger LOG = LogManager.getLogger(PutToWarehouseWithDis.class.getName());

    /**
     * Link to Storage for executing.
     */
    private Storage<E> link;

    /**
     * Constructor, create link to Storage.
     *
     * @param warehouse
     */
    public PutToWarehouseWithDis(Storage<E> warehouse) {
        link = warehouse;
    }

    /**
     * Put Food to storage, make disscount.
     *
     * @param e Food
     */
    @Override
    public void execute(E e) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date today = cal.getTime();
        double check = ((double) (e.getCreatedDate().getTime() - today.getTime()))
                / ((double) (e.getCreatedDate().getTime() - e.getExpairedDate().getTime()));
        e.setDisscount(check);
        link.push(e);
    }
}
