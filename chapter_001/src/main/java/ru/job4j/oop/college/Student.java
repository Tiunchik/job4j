/**
 * Тестовое задание по работе с авто-генеаторами геттеров и сеттеров
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.college;

import java.util.Date;

/**
 * Student - класс хранилище данных по студентам
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 14.12.2019
 */
public class Student {
    /**
     * Поля клсса - данные по учащемуся: имя, фамилия, отчество, номер группы, дата принятия на учёбу;
     */
    private String name;
    private String surname;
    private String patronymic;
    private short studGroup;
    private Date admissionDate;

    /**
     * геттер поля name
     *
     * @return - возвращает значение поля name
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер поля name
     *
     * @param name - аргумент передаваемый в параметр принимается полем клсса -name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * геттер поля surname
     *
     * @return - возвращает значение поля surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Сеттер поля surname
     *
     * @param surname - аргумент передаваемый в параметр принимается полем клсса -surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * геттер поля patronymic
     *
     * @return - возвращает значение поля patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Сеттер поля patronymic
     *
     * @param patronymic - аргумент передаваемый в параметр принимается полем клсса -patronymic
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * геттер поля studGroup
     *
     * @return - возвращает значение поля studGroup
     */
    public short getStudGroup() {
        return studGroup;
    }

    /**
     * Сеттер поля studGroup
     *
     * @param studGroup - аргумент передаваемый в параметр принимается полем клсса -studGroup
     */
    public void setStudGroup(short studGroup) {
        this.studGroup = studGroup;
    }

    /**
     * геттер поля admissionDate
     *
     * @return - возвращает значение поля admissionDate
     */
    public Date getAdmissionDate() {
        return admissionDate;
    }

    /**
     * Сеттер поля admissionDate
     *
     * @param admissionDate - аргумент передаваемый в параметр принимается полем клсса -admissionDate
     */
    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }
}
