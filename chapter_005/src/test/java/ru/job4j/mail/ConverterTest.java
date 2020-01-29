/**
 * Пакет для работы с коллекциями, тестовое задание Почта
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.mail;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Класс ConverterTest - тестовый класс.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 14.01.2019
 */
public class ConverterTest {

    @Test
    public void whenWeTestConverter() {

        List<User> base = new ArrayList<>(List.of(
                new User("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")),
                new User("user2", Set.of("foo@gmail.com", "ups@pisem.net")),
                new User("user3", Set.of("xyz@pisem.net", "vasya@pupkin.com")),
                new User("user4", Set.of("ups@pisem.net", "aaa@bbb.ru")),
                new User("user5", Set.of("xyz@pisem.net"))
        ));

        var test = Converter.converter(base);
        List<User> expected = new ArrayList<>(List.of(
                new User("unknownUser1", Set.of("xyz@pisem.net", "vasya@pupkin.com")),
                new User("unknownUser2", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "aaa@bbb.ru"))

        ));
        //Iterator<User> that = test.iterator();
        //Iterator<User> those = expected.iterator();
        //assertThat(those.next().getEmails(), is(that.next().getEmails()));
        //assertThat(those.next().getEmails(), is(that.next().getEmails()));
        test.forEach(e -> System.out.println(e.getName() + " / " + e.getEmails()));
    }
}