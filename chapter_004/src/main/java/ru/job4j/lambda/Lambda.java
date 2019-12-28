/**
 * Пакет для работы с лямда выражениями
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Класс Lambda - класс с методом требующми опредлениям посредством лямбда выражний
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 28.12.2019
 */
public class Lambda {
    /**
     * Метод для перебора значений и подстановку их в сформированное лямбда выражение
     *
     * @param start - с данного значения начнётся перебор
     * @param end - по данное значеие (не включительно) закончится перебор
     * @param func - функциональный интерфейс для формирования лямбда выражения
     * @return - возвращаемое цифровое значение.
     */
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> temp = new ArrayList<>();
        for (; start < end; start++) {
            temp.add(func.apply((double) start));
        }
        return temp;
    }
}
