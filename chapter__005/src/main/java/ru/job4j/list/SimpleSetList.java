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
 * @version 0.1
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
        var rsl = true;
        if (base.size() != 0) {
            var iter = base.iterator();
            while (iter.hasNext()) {
                if (iter.next().equals(value)) {
                    rsl = false;
                }
            }
        }
        if (rsl) {
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
}
