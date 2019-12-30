/**
 * Пакет для работы с лямда выражениями и steam API
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.lambda.students;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс Admission - содержит метод по выборке и сортировке студентов согласно заданного значения
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 30.12.2019
 */
public class Admission {
    /**
     * Метод для сротировки вы деления группы студентов по баллам
     *
     * @param students - список студентов
     * @param bound - необходимый проходной балл
     * @return - список студентов имебщий необходимый проходной балл
     */
    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .sorted(Comparator.reverseOrder())
                .flatMap(Stream::ofNullable)
                .takeWhile(x -> x.getScore() > bound)
                .collect(Collectors.toList());
    }
}
