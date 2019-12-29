/**
 * Пакет для работы с лямда выражениями и steam API
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.lambda.school;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Класс Academy - класс содержит методы для генерации списка учеников и фильтрации учеников по классам
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 29.12.2019
 */
public class Academy {
    /**
     * Метод предназначен для фильтрации учеников по классам
     *
     * @param students - список студентов типа SchoolBoy
     * @param predict - условие для филтрации
     * @return - список учеников прошедших фильтрацию
     */

    public List<SchoolBoy> collect(List<SchoolBoy> students, Predicate<SchoolBoy> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    /**
     * Метод по созданию списка учеников
     *
     * @param reits - список оценок различных ученкиов
     * @param create - функциональный интерфейс для применения меотда создания класса
     * @return - список учеников
     */
    public List<SchoolBoy> createList(List<Integer> reits, Function<Integer, SchoolBoy> create) {
        List<SchoolBoy> temp = new ArrayList<>();
        reits.forEach(n -> temp.add(create.apply(n)));
        return temp;
    }
}

