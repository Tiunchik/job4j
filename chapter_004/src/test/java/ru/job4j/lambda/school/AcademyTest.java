/**
 * Пакет для работы с лямбда выражениями и stream API
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.lambda.school;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс AcademyTest - класс содержит тесты методов класса Academy
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 30.12.2019
 */
public class AcademyTest {
    /**
     * Тесты работы метода для условия >70 - класс 10А
     */
    @Test
    public void testFor10A() {
        Academy obj = new Academy();
        List<Integer> schoolStudents = Arrays.asList(76, 24, 87, 39, 55, 64);
        List<SchoolBoy> listOfStudents = obj.createListWithoutNames(schoolStudents, SchoolBoy::new);
        List<SchoolBoy> result = obj.collectToList(listOfStudents, (n) -> n.getScore() >= 70);
        Assert.assertEquals(2, result.size());
    }

    /**
     * Тесты работы метода для условия > 50 и < 70 - класс 10А
     */
    @Test
    public void testFor10B() {
        Academy obj = new Academy();
        List<Integer> schoolStudents = Arrays.asList(76, 24, 87, 39, 50, 64);
        List<SchoolBoy> listOfStudents = obj.createListWithoutNames(schoolStudents, SchoolBoy::new);
        List<SchoolBoy> result = obj.collectToList(listOfStudents, (n) -> n.getScore() >= 50 && n.getScore() < 70);
        Assert.assertEquals(2, result.size());
    }

    /**
     * Тесты работы метода для условия > 0 и < 50 - класс 10А
     */
    @Test
    public void testFor10C() {
        Academy obj = new Academy();
        List<Integer> schoolStudents = Arrays.asList(76, 24, 87, 39, 55, 64);
        List<SchoolBoy> listOfStudents = obj.createListWithoutNames(schoolStudents, SchoolBoy::new);
        List<SchoolBoy> result = obj.collectToList(listOfStudents, (n) -> n.getScore() >= 0 && n.getScore() < 50);
        Assert.assertEquals(2, result.size());
    }

    /**
     * Тест метода по созданию списка студентов
     */
    @Test
    public void testCreation() {
        Academy obj = new Academy();
        List<Integer> schoolStudents = Arrays.asList(76, 24, 87, 39, 55, 64);
        List<SchoolBoy> listOfStudents = obj.createListWithoutNames(schoolStudents, SchoolBoy::new);
        Assert.assertEquals(6, listOfStudents.size());
    }

    /**
     * Тест проверяет работу меотда collectToMap
     */
    @Test
    public void surnameTest() {
        Academy obj = new Academy();
        List<SchoolBoy> temp = new ArrayList<>();
        temp.add(new SchoolBoy("Иванов", 94));
        temp.add(new SchoolBoy("Петров", 73));
        temp.add(new SchoolBoy("Сидоров", 25));
        temp.add(new SchoolBoy("Афанасьев", 34));
        Map<String, SchoolBoy> list = obj.collectToMap(temp);
        List<String> expected = temp.stream()
                .map(SchoolBoy::getSurname)
                .collect(Collectors.toList());
        Assert.assertTrue(expected.containsAll(list.keySet()));
    }
}
