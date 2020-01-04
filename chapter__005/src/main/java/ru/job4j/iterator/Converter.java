/**
 * Пакет для работы с коллекциями
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.iterator;

import java.util.*;

/**
 * Класс IterateIterator - класс итератор для массива итераторов
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 04.01.2019
 */
public class Converter {
    /**
     * Метод создания итератора итераторов
     *
     * @param it - итератор нескольких итераторов
     * @return - единый итратор для всех итераторов
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {
            /**
             * Содержит передаваемый для итерации массив итераторов
             */
            Iterator<Iterator<Integer>> innerTemp = it;
            /**
             * Список используется для навигции среди всех итраторов переданы в массиве
             */
            List<Iterator<Integer>> temp = new LinkedList<>();
            /**
             * информирует какой из итераторов сейчас итерируется
             */
            int position = 0;
            /**
             * Склько всего итераторов в массиве
             */
            int index = 0;
            /**
             * Ленивая загрузка переменных в итераторе
             */
            boolean start = false;

            /**
             * Переопределённый метод информирующий о возмоожности дальнейшей итерации
             *
             * @return 1 - если итрация возможна, 0 если значения закончились
             */
            @Override
            public boolean hasNext() {
                if (!(start)) {
                    this.statments();
                }
                var rsl = false;
                for (int i = position; i < index; i++) {
                    if (temp.get(i).hasNext()) {
                        rsl = true;
                        break;
                    }
                }
                return rsl;
            }

            /**
             * Переопределённый метод для итерации по значениям
             *
             * @return - возвращает следующее значение из линии значений
             */
            @Override
            public Integer next() {
                if (!(start)) {
                    this.statments();
                }
                if (!(temp.get(position).hasNext())) {
                    position++;
                }
                if (position == index) {
                    position--;
                }
                return temp.get(position).next();
            }

            /**
             * внутренний меотд для создания внутренних переменных
             */
            private void statments() {
                while (innerTemp.hasNext()) {
                    temp.add(it.next());
                }
                index = temp.size();
                start = true;
            }

        };
    }
}