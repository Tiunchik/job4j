/**
 * Пакет ru.job4j.storage для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.storage;

/**
 * Интерфейс TakeAction - fro actions with Storages
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 21.02.20
 */
public interface TakeAction<E extends Food> {

    void execute(E e);

}
