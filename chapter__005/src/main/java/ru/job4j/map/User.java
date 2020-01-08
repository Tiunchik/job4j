/**
 * Пакет для работы с коллекциями типа Map
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.map;

import java.util.Calendar;

/**
 * Класс User - модель данных
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 08.01.2019
 */
public class User {
    private String name;
    private int children;
    private Calendar bithday;

    public User(String name, int children, Calendar bithday) {
        this.name = name;
        this.children = children;
        this.bithday = bithday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBithday() {
        return bithday;
    }

    public void setBithday(Calendar bithday) {
        this.bithday = bithday;
    }
}
