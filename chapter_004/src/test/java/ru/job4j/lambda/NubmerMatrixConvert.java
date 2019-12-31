/**
 * Пакет для работы с лямбда выражениями и stream API
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс NubmerMatrixConvert - класс содержит метод преобразования "матричной" коллекции в линейную коллекцию,
 * а так же одновременно тест результатов этой коллекции
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 30.12.2019
 */
public class NubmerMatrixConvert {
    /**
     * метод преобразования "матричной" коллекции в линейную коллекцию,
     * а так же одновременно тест результатов этой коллекции
     */
    @Test
    public void converMatrixTest() {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
        );
        List<Integer> result = matrix.stream().flatMap(Collection::stream).collect(Collectors.toList());
        Assert.assertEquals(6, result.size());
    }

    /**
     * Преобразование  матрицы Integer в список объектв типа Integer
     */
    @Test
    public void converIntegerMatrixTest() {
        Integer[][] oldMatrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        List<Integer> list = new ArrayList<Integer>();
        for (Integer[] row : oldMatrix) {
            list.addAll(Arrays.asList(row));
        }
        Assert.assertEquals(6, list.size());
    }

}
