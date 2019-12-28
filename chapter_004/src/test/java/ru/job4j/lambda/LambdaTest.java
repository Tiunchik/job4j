/**
 * Пакет для работы с лямда выражениями
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Класс LambdaTest - класс для тестирования метода с различными лямбда выражениями
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 28.12.2019
 */
public class LambdaTest {
    /**
     * Тест с линейной функцией
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Lambda.diapason(5, 8,
                x -> {
                    return (2 * x + 1);
                });
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    /**
     * Тест с квадратной функцией
     */
    @Test
    public void whenSquerFunctionThenSquerResults() {
        List<Double> result = Lambda.diapason(5, 8,
                x -> {
                    return (Math.pow(x, 2) - x - 2);
                });
        List<Double> expected = Arrays.asList(18D, 28D, 40D);
        assertThat(result, is(expected));
    }
    /**
     * Тест с логарифмической функцией
     */
    @Test
    public void whenLogarithmFunctionThenLogarithmResults() {
        List<Double> result = Lambda.diapason(5, 8,
                x -> {
                    return (Math.log10(x));
                });
        List<Double> expected = Arrays.asList(0.69, 0.77, 0.84);
        Assert.assertEquals(expected.get(0),result.get(0), 0.01);
        Assert.assertEquals(expected.get(1),result.get(1), 0.01);
        Assert.assertEquals(expected.get(2),result.get(2), 0.01);
    }
}
