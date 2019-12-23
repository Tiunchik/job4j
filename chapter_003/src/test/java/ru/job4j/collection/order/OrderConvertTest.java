/**
 * Пакет для работы с коллекцией HashSet
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.order;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс OrderConvertTest - класс для теста конвертации коллекции Order в коллекцию HashSet.
 *
 * @author -
 * @version -
 * @since 22.12.2019
 */
public class OrderConvertTest {
    /**
     * Автоматический тест метода process
     */
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("0"), is(new Order("3sfe", "Dress")));
    }
}
