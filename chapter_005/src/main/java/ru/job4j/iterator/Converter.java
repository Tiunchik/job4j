/**
 * Пакет для работы с коллекциями
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Класс IterateIterator - класс итератор для массива итераторов
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 03.01.2019
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {

            Iterator<Integer> temp = it.next();

            @Override
            public boolean hasNext() {
                var rsl = false;
                if (temp.hasNext()) {
                    rsl = true;
                } else {
                    while (it.hasNext()) {
                        temp = it.next();
                        if (temp.hasNext()) {
                            rsl = true;
                            break;
                        }
                    }
                }
                return rsl;
            }

            @Override
            public Integer next() {
                if (!(temp.hasNext())) {
                    temp = it.next();
                }
                return temp.next();
            }

        };
    }
}