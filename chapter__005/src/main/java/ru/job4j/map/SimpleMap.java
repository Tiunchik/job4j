/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс SimpleMap - упрощенный вариант коллекци HashMap
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 09.01.2019
 */
public class SimpleMap<K, V> implements Map<K, V>, Iterable<K> {

    /**
     * Корзины
     */
    private Node<K, V>[] table;
    /**
     * Размер коллекции
     */
    private int size = 0;
    /**
     * Счётчик изменений
     */
    private int modeCount = 0;
    /**
     * Коэфициент заполненности коллекции
     */
    private double persent = 0.75;

    /**
     * Создать/расширить таблицу корзин
     */
    private void changeTab() {
        if (table == null) {
            table = (Node<K, V>[]) new Node[16];
        } else {
            Node<K, V>[] oldTable = table;
            table = (Node<K, V>[]) new Node[table.length * 2];
            for (var temp : oldTable) {
                if (temp != null) {
                    insert(temp.key, temp.value);
                }
            }
        }
    }

    /**
     * Сформировать hash - плагиат
     *
     * @param key - ключ
     * @return - откорректированный хэш
     */
    private int hash(K key) {
        int h;
        if (key == null) {
            h = 0;
        } else {
            h = key.hashCode();
            h = h ^ (h >>> 16);
        }
        return h;
    }

    /**
     * вставить значение в таблицу
     *
     * @param key   - ключ
     * @param value - хначение
     * @return 1 - если добавлено, 0 - если уже есть такое значение в корзине
     */
    @Override
    public boolean insert(K key, V value) {
        if (table == null || ((size / table.length) > persent)) {
            changeTab();
        }
        if (table[hash(key) & (table.length - 1)] == null) {
            table[hash(key) & (table.length - 1)] = new Node<>(key, value);
            size++;
            modeCount++;
            return true;
        }
        return false;
    }

    /**
     * получиь значение по ключу
     *
     * @param key - ключ
     * @return - значение
     */
    @Override
    public V get(K key) {
        if (table[hash(key) & (table.length - 1)] != null) {
            return table[hash(key) & (table.length - 1)].value;
        }
        return null;
    }

    /**
     * удалить значение по ключу
     *
     * @param key - ключ
     * @return 1 - если удалено, 0 - если нет такого значения
     */
    @Override
    public boolean delete(K key) {
        if (table[hash(key) & (table.length - 1)] != null) {
            table[hash(key) & (table.length - 1)] = null;
            modeCount++;
            return true;

        }
        return false;
    }

    /**
     * возвращает набор ключей из таблицы
     *
     * @return - набор ключей
     */
    public K[] keySet() {
        Object[] answer = new Object[size];
        var index = 0;
        for (var temp : table) {
            if (temp != null) {
                answer[index++] = temp;
            }
        }
        return (K[]) answer;
    }

    /**
     * итератор по ключам таблицы
     *
     * @return - возвращает итератор
     */
    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {

            private int modified = modeCount;
            private K[] line = keySet();
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position > line.length;
            }

            @Override
            public K next() {
                if (modified != getModCount()) {
                    throw new ConcurrentModificationException("Array was modificated");
                }
                if (!hasNext()) {
                    throw new NoSuchElementException("Array is expired");
                }
                return line[position++];
            }
        };
    }

    /**
     * Размер коллекции
     *
     * @return - разер коллекции
     */
    public int size() {
        return size;
    }

    /**
     * гетер счётчика изменений
     *
     * @return - значение счётчика изменений
     */
    public int getModCount() {
        return modeCount;
    }

    /**
     * геттер процента роста количества корзин
     *
     * @return процент зполняемости корзин
     */
    public double getPersent() {
        return persent;
    }

    /**
     * сеттер для % заполняемости корзин
     *
     * @param persent - новый процент заполняемости
     */
    public void setPersent(double persent) {
        this.persent = persent;
    }

    /**
     * внутренний класс для формирования таблицы
     *
     * @param <K>
     * @param <V>
     */
    static class Node<K, V> {
        K key;
        V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
