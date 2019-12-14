/**
 * Тестовое задание по работе с авто-генеаторами геттеров и сеттеров
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.college;

import java.util.Date;

/**
 * College - класс для запуска и проверки класса Student, содержит только метод main
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 14.12.2019
 */
public class College {
    /**
     * Метод main
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        Student one = new Student();
        one.setName("Maksim");
        one.setPatronymic("Nikolaevich");
        one.setSurname("Tiunchik");
        one.setStudGroup(((short) 134));
        one.setAdmissionDate(new Date());

        System.out.println(one.getName() + " " + one.getPatronymic() + " " + one.getSurname() + ", have been enrolled in group "
                + one.getStudGroup() + " since " + one.getAdmissionDate());

    }
}
