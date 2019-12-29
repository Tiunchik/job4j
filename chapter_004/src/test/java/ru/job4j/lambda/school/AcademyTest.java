/**
 * Пакет для работы с лямда выражениями и steam API
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.lambda.school;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс AcademyTest - класс содержит тесты методов класса Academy
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 29.12.2019
 */
public class AcademyTest {
    /**
     * Тесты работы метода для условия >70 - класс 10А
     */
    @Test
    public void testFor10A() {
        Academy obj = new Academy();
        List<Integer> schoolStudents = Arrays.asList(76, 24, 87, 39, 55, 64);
        List<SchoolBoy> listOfStudents = obj.createList(schoolStudents, SchoolBoy::new);
        List<SchoolBoy> result = obj.collect(listOfStudents, (n) -> n.getScore() >= 70);
        Assert.assertEquals(2, result.size());
    }

    /**
     * Тесты работы метода для условия > 50 и < 70 - класс 10А
     */
    @Test
    public void testFor10B() {
        Academy obj = new Academy();
        List<Integer> schoolStudents = Arrays.asList(76, 24, 87, 39, 50, 64);
        List<SchoolBoy> listOfStudents = obj.createList(schoolStudents, SchoolBoy::new);
        List<SchoolBoy> result = obj.collect(listOfStudents, (n) -> n.getScore() >= 50 && n.getScore() < 70);
        Assert.assertEquals(2, result.size());
    }

    /**
     * Тесты работы метода для условия > 0 и < 50 - класс 10А
     */
    @Test
    public void testFor10C() {
        Academy obj = new Academy();
        List<Integer> schoolStudents = Arrays.asList(76, 24, 87, 39, 55, 64);
        List<SchoolBoy> listOfStudents = obj.createList(schoolStudents, SchoolBoy::new);
        List<SchoolBoy> result = obj.collect(listOfStudents, (n) -> n.getScore() >= 0 && n.getScore() < 50);
        Assert.assertEquals(2, result.size());
    }

    /**
     * Тест метода по созданию списка студентов
     */
    @Test
    public void testCreation() {
        Academy obj = new Academy();
        List<Integer> schoolStudents = Arrays.asList(76, 24, 87, 39, 55, 64);
        List<SchoolBoy> listOfStudents = obj.createList(schoolStudents, SchoolBoy::new);
        Assert.assertEquals(6, listOfStudents.size());
    }
}
