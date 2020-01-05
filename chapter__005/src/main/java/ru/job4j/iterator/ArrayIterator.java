/**
 * Пакет для работы с коллекциями
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс ArrayIterator - класс итератор для двумерного массива
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 03.01.2019
 */
public class ArrayIterator implements Iterator {
    /**
     * содержит двумерный массив по которому идёт итерация
     */
    private final int[][] base;
    /**
     * содержит данные о положении каретки в линейном массиве
     */
    private int length;
    /**
     * содержит данные о том, в какои из массивов сейчас аретка
     */
    private int deep;

    /**
     * Конструктор итератора, задаёт часть переменных
     *
     * @param base - передаваемая в итератор матрица
     */
    public ArrayIterator(int[][] base) {
        this.base = base;
        this.deep = 0;
        this.length = 0;
    }

    /**
     * Переопределённый метод итератора - даёт информацию о том, прошёл итератор весь массив или нет
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        return deep != base.length;
    }

    /**
     * возвращает значение из матрицы, при повторном вызове возвращает следующее значение из матрицы, при
     * первом вызове возвращает перве значение матрицы
     *
     * @return возвращает значение из матрицы
     */
    @Override
    public Object next() {
        if (deep == base.length) {
            throw new NoSuchElementException("Array is excted");
        }
        int temp = base[deep][length++];
        if (length == base[deep].length) {
            length = 0;
            deep++;
        }
        return temp;
    }
}
