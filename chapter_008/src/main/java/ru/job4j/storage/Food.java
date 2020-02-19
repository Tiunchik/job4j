/**
 * Пакет ru.job4j.storage для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.calculator.Calculator;

import java.util.Calendar;
import java.util.Date;

/**
 * Класс Food - model of data
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.02.2020
 */
public class Food implements Prog {
    private static final Logger LOG = LogManager.getLogger(Food.class.getName());
    /**
     * name of Food.
     */
    private String name;
    /**
     * expaired date of food.
     */
    private final Date expairedDate;
    /**
     * creation date of food.
     */
    private final Date createdDate;
    /**
     * price of food.
     */
    private double price;
    /**
     * disscount of food.
     */
    private double disscount;

    /**
     * default constructor for food.
     *
     * @param name name
     * @param expaired expaired date
     * @param createdDate date of creation
     * @param price price
     * @param disscount disscount
     */
    public Food(String name, Date expaired, Date createdDate, double price, double disscount) {
        this.name = name;
        this.expairedDate = expaired;
        this.createdDate = createdDate;
        this.price = price;
        this.disscount = disscount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getExpairedDate() {
        return expairedDate;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getDisscount() {
        return disscount;
    }

    @Override
    public void setDisscount(double disscount) {
        this.disscount = disscount;
    }
}
