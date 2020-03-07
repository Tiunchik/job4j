/**
 * Package ru.job4j.design for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.design;

import java.util.Calendar;
import java.util.Objects;

/**
 * Class Employer - model of data.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.03.2020
 */
public class Employer {

    /**
     * name of worker.
     */
    private String name;
    /**
     * date when worker has been hired.
     */
    private Calendar hired;
    /**
     * date when worker has been fired.
     */
    private Calendar fired;
    /**
     * salary of worker.
     */
    private double salary;

    /**
     * Constructor for worker.
     *
     * @param name   name
     * @param hired  date of hiring
     * @param fired  date of firing
     * @param salary base salary
     */
    public Employer(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    /**
     * getter for name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for hired.
     *
     * @return hired
     */
    public Calendar getHired() {
        return hired;
    }

    /**
     * setter for hired.
     */
    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    /**
     * getter for fired.
     *
     * @return fired
     */
    public Calendar getFired() {
        return fired;
    }

    /**
     * setter for fired.
     */
    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    /**
     * getter for salary.
     *
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * setter for salary.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employer employer = (Employer) o;
        return Objects.equals(name, employer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
