/**
 * Пакет для работы с коллекциями/итератором/генериками
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.iterator.generic.store;

/**
 * Класс UserStore - база данных объектов User
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 05.01.2019
 */
public class UserStore<User> extends AbstractStore {

    public UserStore(int size) {
        super(size);
    }
}
