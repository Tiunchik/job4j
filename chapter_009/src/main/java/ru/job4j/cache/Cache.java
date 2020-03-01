/**
 * Package ru.job4j.cache for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.cache;

/**
 * Interface Cache -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 01.03.2020
 */
public interface Cache<K, V> {

    void insert(K key, V value);

    V get(K key);

    boolean delete(K key);

    V load(K key);

}
