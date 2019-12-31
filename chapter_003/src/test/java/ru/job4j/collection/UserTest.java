/**
 * Пакет для работы с коллекциями ArrayList/LinkedList/HashSet/TreeSet
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс UserTest исползуется для автоматических тестов методов класса User
 *
 * @author -
 * @version 0.1
 * @since 24.12.2019
 */
public class UserTest {

    @Test
    public void whenAsc() {
        Set<User> users = Set.of(
                new User("ivan", 31),
                new User("petr", 32),
                new User("max", 29)
        );
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("ivan", 31)));
        assertThat(it.next(), is(new User("max", 29)));
        assertThat(it.next(), is(new User("petr", 32)));


    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }
}