/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author -
 */
package ru.job4j.analizy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

/**
 * Класс AnalizeTest - класс содержит тесты
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 23.01.2019
 */
public class AnalizeTest {

    @Test
    public void whenTwoCollectionsTheSameSizeAndTwoWasDeletedTwoAddedTwoChanged() {
        List<Analize.User> first = new ArrayList<>();
        first.add(new Analize.User(1, "One"));
        first.add(new Analize.User(2, "Two"));
        first.add(new Analize.User(3, "Three"));
        first.add(new Analize.User(4, "Four"));
        first.add(new Analize.User(5, "Five"));
        first.add(new Analize.User(6, "Sex"));


        List<Analize.User> second = new ArrayList<>();
        second.add(new Analize.User(1, "One"));
        second.add(new Analize.User(2, "Two"));
        second.add(new Analize.User(3, "Four"));
        second.add(new Analize.User(4, "Five"));
        second.add(new Analize.User(8, "Five"));
        second.add(new Analize.User(9, "Sex"));

        Analize temp = new Analize();

        Analize.Info expected = new Analize.Info();
        expected.added = 2;
        expected.deleted = 2;
        expected.changed = 2;

        Analize.Info answer = temp.diff(first, second);

        assertTrue(expected.equals(answer));

    }

    @Test
    public void whenTwoCollectionsDifferentSizeAndTwoWasDeletedTwoChanged() {
        List<Analize.User> first = new ArrayList<>();
        first.add(new Analize.User(1, "One"));
        first.add(new Analize.User(2, "Two"));
        first.add(new Analize.User(3, "Three"));
        first.add(new Analize.User(4, "Four"));
        first.add(new Analize.User(5, "Five"));
        first.add(new Analize.User(6, "Sex"));


        List<Analize.User> second = new ArrayList<>();
        second.add(new Analize.User(1, "One"));
        second.add(new Analize.User(2, "Two"));
        second.add(new Analize.User(3, "Four"));
        second.add(new Analize.User(4, "Five"));


        Analize temp = new Analize();

        Analize.Info expected = new Analize.Info();
        expected.added = 0;
        expected.deleted = 2;
        expected.changed = 2;

        Analize.Info answer = temp.diff(first, second);

        assertTrue(expected.equals(answer));

    }

}