/**
 * Тестовое задание по приведению объектов
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.othercollege;

/**
 * College - суперкласс для подкласа Student;
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 15.12.2019
 */
public class College {
    /**
     * Метод main
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        Freshman newbie = new Freshman();
        Student student = newbie;
        College coll = student;
        Object ob = newbie;
        ob = coll;
        Freshman oldMeat = (Freshman) student;


    }
}
