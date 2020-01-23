/**
 * Пакет для работы с коллекциями/итератором/генериками
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.iterator.generic.store;

/**
 * Класс RoleStore - база данных объектов Role
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 05.01.2019
 */
public class RoleStore<Role> extends AbstractStore {
    public RoleStore(int size) {
        super(size);
    }
}
