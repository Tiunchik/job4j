/**
 * Пакет для тестового задания по сортировке и работе со списками "отортровать департаменты"
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Класс DepartmentsTest - набор тестов для класа Departments
 *
 * @author -
 * @version 0.1
 * @since 28.12.2019
 */
public class DepartmentsTest {
    /**
     * Тест метода fillGaps
     */
    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }
    /**
     * Тест метода fillGaps
     */
    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }
    /**
     * Тест метода fillGaps
     */
    @Test
    public void whenTwoMissed() {
        List<String> input = List.of("K2/SK1/SSK1");
        List<String> expect = List.of("K2", "K2/SK1", "K2/SK1/SSK1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }
    /**
     * Тест метода sortAsc
     */
    @Test
    public void sortNaturalOrdering() {
        List<String> input = Arrays.asList("K2/SK1", "K2/SK1/SSK1", "K2");
        //https://stackoverflow.com/questions/46579074/what-is-the-difference-between-list-of-and-arrays-aslist
        List<String> expect = Arrays.asList("K2", "K2/SK1", "K2/SK1/SSK1");
        Departments.sortAsc(input);
        assertThat(input, is(expect));
    }
    /**
     * Тест метода sortDesc
     */
    @Test
    public void sortComparatoUse() {
        List<String> input = Arrays.asList("K1/SK1", "K2/SK1");
        List<String> expect = Arrays.asList("K2/SK1", "K1/SK1");
        Departments.sortDesc(input);
        assertThat(input, is(expect));
    }
}