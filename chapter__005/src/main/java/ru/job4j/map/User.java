/**
 * Пакет для работы с коллекциями типа Map
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

/**
 * Класс User - модель данных
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
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

    /*
    @SuppressWarnings("checkstyle:EqualsHashCode")
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getChildren(), getBithday());
    }

     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return getName().equals(user.getName())
                && getChildren() == user.getChildren()
                && getBithday() == user.getBithday();
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
