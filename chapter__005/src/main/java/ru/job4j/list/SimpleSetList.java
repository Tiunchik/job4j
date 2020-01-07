/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.list;

import java.util.Iterator;

/**
 * Класс SimpleSetList - класс коллекция - иммитация коллекции Set
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 07.01.2019
 */
public class SimpleSetList<E> implements CollectionsList<E>, Iterable<E> {
    /**
     * композиция - класс-массив LifeArrayList
     */
    private LifeArrayList<E> base = new LifeArrayList<>(100);

    /**
     * Добавление элемента в коллкецию
     *
     * @param value значение добавляемого элемента
     */
    @Override
    public void add(E value) {
        if (!contains(value)) {
            base.add(value);
        }
    }

    /**
     * Итератор для коллекции
     *
     * @return создаёт итератор для коллекции
     */
    @Override
    public Iterator<E> iterator() {
        return base.iterator();
    }

    /**
     * Возвращает размер коллекции
     *
     * @return возращает размер коллекции
     */
    public int size() {
        return base.size();
    }

    public boolean contains(E value) {
        var rsl = false;
        if (base.size() != 0) {
            var iter = base.iterator();
            while (iter.hasNext()) {
                if (iter.next().equals(value)) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }
}
