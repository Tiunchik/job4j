/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс LifeLinkedList - класс коллекция-стэк. Организован по принципу - FIFO
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 06.01.2019
 */
public class LifeLinkedList<E> implements CollectionsList<E>, Iterable<E> {
    /**
     * Текущий размер коллкеции
     */
    private int size = 0;
    /**
     * Первое значение в коллекции
     */
    private Node<E> first;
    /**
     * Последнее значенеи в коллекции
     */
    private Node<E> last;
    /**
     * Счётчик изменний
     */
    private int modCount = 0;

    /**
     * Добавить значение в связанный список
     *
     * @param value - добавляемое значение
     */
    @Override
    public void add(E value) {
        Node<E> temp = new Node<E>(value);
        size++;
        modCount++;
        if (first == null) {
            first = temp;
        } else if (last == null) {
            last = temp;
            first.next = last;
        } else {
            last.next = temp;
            last = temp;
        }
    }
    /**
     * получить значение по индексу
     *
     * @param index - индекс для поиска значения
     * @return - значение в коллекции соответствующее индкесу
     */

    public E get(int index) {
        if (index > size) {
            return null;
        }
        Iterator<E> temp = iterator();
        int circle = 0;
        while (temp.hasNext()) {
            if (circle == index) {
                return temp.next();
            }
            temp.next();
            circle++;
        }
        return null;
    }

    /**
     * Создать итератор
     *
     * @return итератор
     */
    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private final int itModCount = modCount;
            private int index = 0;
            private final int itSize = size;
            private Node<E> current;

            @Override
            public boolean hasNext() {
                return index < itSize;
            }

            @Override
            public E next() {
                Node<E> temp;
                if (itModCount != getModCount()) {
                    throw new ConcurrentModificationException("Array was modificated");
                }
                if (!hasNext()) {
                    throw new NoSuchElementException("Array is expired");
                }
                if (index == 0) {
                    current = first;
                }
                temp = current;
                index++;
                current = current.next;
                return temp.data;
            }
        };
    }

    /**
     * Возвращает первое добавленное значение и удаляет его из списка
     *
     * @return первое значение
     */
    public E delete() {
        if (size > 0) {
            Node<E> temp = first;
            if (size > 2) {
                first = first.next;
            } else {
                first = null;
            }
            size--;
            modCount++;
            return temp.data;
        }
        return null;
    }

    /**
     * возращает длину списка
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * возвращает значение счётчика изменений
     *
     * @return значение счётчика изменений
     */
    public int getModCount() {
        return modCount;
    }

    /**
     * внутренний класс
     *
     * @param <E> - значение для хранения
     */
    public class Node<E> {

        E data;
        Node<E> next;

        Node(E info) {
            data = info;
        }

    }
}
