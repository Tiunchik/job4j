/**
 * Пакет для работы с лямда выражениями и steam API
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.lambda.students;



/**
 * Класс Student - класс модель данных
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 30.12.2019
 */
public class Student implements Comparable<Student> {
    /**
     * Имя ученика
     */
    private String name;
    /**
     * Фамилия ученика
     */
    private String surname;
    /**
     * Уровень баллов ученика
     */
    private int score;

    /**
     * дефолтный конструктор
     */
    public Student() {
    }

    /**
     * конструктор клсса, сразу задаёт уровень баллов ученика
     *
     * @param x - параметр получающий аргумент с уровнем баллов ученика
     */

    public Student(int x) {
        score = x;
    }

    /**
     * конструктор клсса, сразу задаёт уровень баллов ученика и его имя
     *
     * @param name - имя ученика
     * @param score   - уровень баллов ученика
     */
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Геттер на переменную score
     *
     * @return возвращает уровень баллов ученика
     */
    public int getScore() {
        return score;
    }

    /**
     * Геттер на переменную name
     *
     * @return возвращает имя ученика
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя учника
     *
     * @param name - аргумент данного параметра будет установлен как имя ученика
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * получить ффамилию ученика
     *
     * @return возвращает фамилию ученка
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Задать фамилию ученика
     *
     * @param surname - фаилия яченика
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Метод сравнения студентов по кличесту их баллов
     *
     * @param o - студент с которым проихсодит сравнение
     * @return 0 - если равны, >0 - если первый стыдент миеет большие балл, <0 если второй студент имеет больший балл
     */
    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.getScore(), o.getScore());

    }
}
