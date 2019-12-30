/**
 * Пакет для работы с лямда выражениями и steam API
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.lambda.students;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс AdmissionTest - тесты для класса Admission
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 30.12.2019
 */
public class AdmissionTest {
    /**
     * Тест работы метода levelOf
     */
    @Test
    public void admissionfirstTest() {
        List<Student> temp = new ArrayList<>();
        temp.add(new Student("Максим", 64));
        temp.add(new Student());
        temp.add(new Student("Игорь", 32));
        temp.add(new Student());
        temp.add(new Student("Андрей", 76));
        temp.add(new Student());
        temp.add(new Student("Николай", 94));
        temp.add(new Student());
        List<Student> expected = new Admission().levelOf(temp, 70);
        Assert.assertEquals(expected.size(), 2);
    }

}
