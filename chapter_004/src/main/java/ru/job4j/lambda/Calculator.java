/**
 * Пакет для работы с лямда выражениями
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
/**
 * Класс Calculator - учебный клас для отработки использования лямда метода
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 28.12.2019
 */
public class Calculator {
    /**
     * Метод в котором используются фукнциональные интрфейсы
     *
     * @param start переменная задающая старт цикла
     * @param finish переменная задающая конец цикла
     * @param value - переменая на которую "действие функции" распостраняется
     * @param op - переменная функционального интерфейса
     * @param media - переменная функционального интерфейса, выводит на консоль результаты работы op
     */
    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    /**
     * Метод main
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        Calculator temp = new Calculator();
        temp.multiple(2, 10, 5, (value, multy) -> {
            double result = value * multy;
            return result;
        }, result -> System.out.println(result));
    }
}
