/**
 * Пакет ru.job4j.storage для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.storage;

import java.util.Date;

/**
 * Интерфейс Prog - model of data
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.02.20
 */
public interface Prog {

    void setName(String name);

    void setPrice(double price);

    void setDisscount(double disscount);

    Date getCreatedDate();

    String getName();

    Date getExpairedDate();

    double getPrice();

    double getDisscount();


}
