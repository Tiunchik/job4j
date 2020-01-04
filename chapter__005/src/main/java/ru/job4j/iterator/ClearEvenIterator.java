/**
 * Пакет для работы с коллекциями/итератором
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс ClearEvenIterator - класс итератор для линейного массива - итрация происходит только по чётным числам
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 04.01.2019
 */
public class ClearEvenIterator implements Iterator {
    /**
     * Содержит линейный массив по которому идёт итерация
     */
    private final int[] base;
    /**
     * Содержит длину линейного массива массиве
     */
    private final int length;
    /**
     * Текущее положение в массиве
     */
    private int position = 0;

    /**
     * Конструктор итератора, задаёт часть переменных
     *
     * @param base - передаваемая в итератор матрица
     */
    public ClearEvenIterator(int[] base) {
        this.base = base;
        this.length = base.length;
    }

    /**
     * Даёт информацию о том, есть ли еще чётные числа в массиве или нет
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        return counter() != -1;
    }

    /**
     * Возвращает чётное значение из матрицы, генерирует исключение, если чётных числе не осталось
     *
     * @return возвращает значение из матрицы
     */
    @Override
    public Object next() {
        int temp, x = counter();
        if (x == -1) {
            throw new NoSuchElementException("There is no more ever elements in array");
        }
        temp = base[x];
        position++;
        return temp;
    }

    /**
     * Внутренний метод определяющий наличие чётного числа в массиве для итрации или проверки их наличия
     *
     * @return возвращает индекс чётного числа в массиве, либо -1 если чётноо числа нет
     */
    private int counter() {
        var rsl = -1;
        for (int index = position; index < length; index++) {
            if (base[index] % 2 == 0) {
                position = index;
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}