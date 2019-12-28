/**
 * Пакет для тестового задания по сортировке и работе со списками "отортровать департаменты"
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

/**
 * Класс DepDescCompTest - набор тестов для класа DepDescComp
 *
 * @author -
 * @version 0.1
 * @since 28.12.2019
 */
public class DepDescCompTest {
    /**
     * Тест работы компоратора
     */
    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, lessThan(0)); //почему больше а не меньше? В этом же суть данного компоратора, а вывод из теста как при естественном порядке
    }
}