package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserTest {


    @Test
    public void whenEqualsAndHashIsStandart() {
        User one = new User("Ivanov", 3, new GregorianCalendar(2005, Calendar.JANUARY, 15));
        User two = new User("Ivanov", 3, new GregorianCalendar(2005, Calendar.JANUARY, 15));
        Map<User, Integer> base = new HashMap<>(Map.of(
                one, 1,
                two, 2
        ));
        System.out.println(base);

    }
}