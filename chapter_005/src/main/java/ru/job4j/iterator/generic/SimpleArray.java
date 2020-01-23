/**
 * Пакет для работы с коллекциями/итератором/генериками
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.iterator.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс SimpleArray - класс "коллекция", содержит в себе массив для хранения данных согласно генерика
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 05.01.2019
 */
public class SimpleArray<T> {
    /**
     * Массив где всё хранится
     */
    private Object[] base;
    /**
     * Текущая позиция для добавления элементов в массив
     */
    private int position = 0;

    /**
     * Конструктор коллекции
     *
     * @param size - размер массива в коллекции
     */
    public SimpleArray(int size) {
        this.base = new Object[size];
    }

    /**
     * Добавления значения в коллекцию
     *
     * @param temp - добавляемое значение
     */
    public void add(T temp) {
        this.base[position++] = temp;
    }

    /**
     * Изменние значения в коллекции
     *
     * @param index - номер ячейки массива которую меняют
     * @param temp  - новое значение
     */
    public void set(int index, T temp) {
        this.base[index] = temp;
    }

    /**
     * Удаление значения в ячейке массива
     *
     * @param index - номер ячейки
     */
    public void remove(int index) {
        System.arraycopy(base, index + 1, base, index, base.length - index - 1);
        this.base[base.length - 1] = null;
    }

    /**
     * Возврат значения из ячейки
     *
     * @param index - номер ячейки
     * @return - возвращаемое значение типа Т
     */
    public T get(int index) {
        return (T) this.base[index];
    }

    /**
     * Иретатор для массива
     *
     * @return - озвращает иретатор для массива
     */
    public Iterator<T> iretator() {
        return new Iterator<T>() {

            private Object[] iterBase = base;
            private int iterPos = 0;
            private int end = base.length;

            @Override
            public boolean hasNext() {
                return iterPos < end;
            }

            @Override
            public T next() {
                if (iterPos == end) {
                    throw new NoSuchElementException("Array is expired");
                }
                return (T) iterBase[iterPos++];
            }
        };
    }

}
