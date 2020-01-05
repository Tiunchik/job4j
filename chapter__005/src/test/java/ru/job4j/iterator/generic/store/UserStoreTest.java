/**
 * Пакет для работы с коллекциями/итератором/генериками
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.iterator.generic.store;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Класс UserStoreTest - пакет тестов для хранилища UserTest
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 05.01.2019
 */
public class UserStoreTest {

    private UserStore temp = new UserStore(10);

    @Before
    public void setUp() throws Exception {
        temp.add(new User("first"));
        temp.add(new User("second"));
        temp.add(new User("third"));
    }

    @Test
    public void addAndFindByIDTest() {
        temp.add(new User("fourth"));
        Base expected = temp.findById("fourth");
        assertEquals(expected, temp.findById("fourth"));
    }

    @Test
    public void replace() {
        Assert.assertTrue(temp.replace("first", new User ("one")));
        assertEquals("one", temp.findById("one").getId());
    }

    @Test
    public void delete() {
        temp.delete("second");
        assertNull(temp.findById("second"));
    }

    @Test
    public void findById() {
        assertEquals("third", temp.findById("third").getId());
    }
}