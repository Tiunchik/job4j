/**
 * Пакет ru.job4j.oop.tracker для разработки решений по трекеру во 2 и 7 частях обучения на курсе
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

/**
 * Интерфейс ITracker - организует требования к классам типа Tracker (SQL,Collections ext.)
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 04.02.2020
 */
public interface ITracker {

    Item add(Item item);

    boolean replace(String id, Item item);

    boolean delete(String id);

    Item[] findAll();

    Item[] findByName(String key);

    Item findById(String id);
}

