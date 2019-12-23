/**
 * Пакет для работы с коллекцией HashSet
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.order;

import java.util.Objects;
/**
 * Класс Order - класс - модуль данных.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 22.12.2019
 */
public class Order {
    private String number;
    private String name;

    public Order(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Order{"
                + "number='" + number + '\''
                + ", name='" + name + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(number, order.number) &&
                Objects.equals(name, order.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}