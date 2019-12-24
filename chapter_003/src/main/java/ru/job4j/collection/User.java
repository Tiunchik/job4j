/**
 * Пакет для работы с коллекциями ArrayList/LinkedList/HashSet/TreeSet
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
/**
 * Класс User исползуется для отработки переопределения метода compateTo
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.12.2019
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(@NotNull User o) {
        if ((name.compareTo(o.name) == 0)) {
            return Integer.compare(age - o.age, 0); //либо   age - o.age > 0 ? 1 : age - o.age == 0 ? 0 : -1;
        }
        return name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

