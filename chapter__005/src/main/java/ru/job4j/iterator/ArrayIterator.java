/**
 * Пакет для работы с коллекциями
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.iterator;

import java.util.Iterator;

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
     * содержит длину каждого линейного массива в двумерном массиве
     */
    private final int[] length;
    /**
     * содеержит длину двумерного массива
     */
    private final int deep;
    /**
     * позиция в линейной матрице на текущий момент
     */
    private int posLength = 0;
    /**
     * в какой матрице сейчас находится итератор
     */
    private int posDeep = 0;
    /**
     * итератор прошёл все позиции матрицы или нет
     */
    private boolean end = true;

    /**
     * Конструктор итератора, задаёт часть переменных
     *
     * @param base - передаваемая в итератор матрица
     */
    public ArrayIterator(int[][] base) {
        this.base = base;
        this.deep = base.length;
        this.length = new int[deep];
        for (int index = 0; index < this.deep; index++) {
            this.length[index] = base[index].length;
        }
    }

    /**
     * Переопределённый метод итератора - даёт информацию о том, прошёл итератор весь массив или нет
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        return end;
    }

    /**
     * возвращает значение из матрицы, при повторном вызове возвращает следующее значение из матрицы, при
     * первом вызове возвращает перве значение матрицы
     *
     * @return возвращает значение из матрицы
     */
    @Override
    public Object next() {
        int temp = base[posDeep][posLength];
        if (end) {
            posLength++;
            if (posLength == length[posDeep]) {
                posDeep++;
                posLength = 0;
            }
            if (posDeep == deep) {
                posDeep = deep - 1;
                posLength = length[deep - 1] - 1;
                end = false;
            }
        }
        return temp;
    }
}
