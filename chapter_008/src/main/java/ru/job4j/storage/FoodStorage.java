/**
 * Пакет ru.job4j.storage для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс FoodStorage  - class storage for data model Food.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.02.20.
 */
public class FoodStorage<T extends Food> implements Storage<T> {
    private static final Logger LOG = LogManager.getLogger(FoodStorage.class.getName());
    /**
     * inner list for keeping T objects
     */
    private LinkedList<T> base = new LinkedList<>();

    /**
     * get and remove T from base
     *
     * @return T from base
     */
    @Override
    public T get() {
        return base.pollLast();
    }

    /**
     * push T to base list
     *
     * @param t pushed argument
     */
    @Override
    public void push(T t) {
        base.push(t);
    }

    /**
     * check is there any T into base
     *
     * @return true or false
     */
    @Override
    public boolean hasNext() {
        return base.peekLast() != null;
    }
}

