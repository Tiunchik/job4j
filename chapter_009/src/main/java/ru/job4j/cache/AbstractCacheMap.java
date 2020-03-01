/**
 * Package ru.job4j.cache for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.ref.SoftReference;
import java.util.HashMap;

/**
 * Class AbstractCacheMap -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 01.03.2020
 */
public abstract class AbstractCacheMap<K, V> implements Cache<K, V> {
    /**
     * inner logger
     */
    private static final Logger LOG = LogManager.getLogger(AbstractCacheMap.class.getName());

    /**
     * Composition of hashMap for keeping Softreference
     */
    private HashMap<K, SoftReference<V>> collect = new HashMap<>();

    /**
     * Insert value to CacheMap? create Softrefeence
     *
     * @param key   key to get information from Map
     * @param value object which will be created sofrreferense for
     */
    @Override
    public void insert(K key, V value) {
        collect.put(key, new SoftReference<>(value));
    }

    /**
     * get object from cache collection,
     * if onject is missimg, it will be adde to collction
     *
     * @param key key to find object
     * @return value for key
     */
    @Override
    public V get(K key) {
        V temp = null;
        if (collect.containsKey(key)) {
            temp = collect.get(key).get();
        }
        if (temp == null) {
            temp = load(key);
            insert(key, temp);
        }
        return temp;
    }

    /**
     * Delete link from Map, according to key
     *
     * @param key key to find link for deliting
     * @return true if object have been deleted
     */
    @Override
    public boolean delete(K key) {
        collect.remove(key);
        return collect.containsKey(key);
    }
}
