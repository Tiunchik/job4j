package ru.job4j.parsersqlsite;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParseLinksFromPageTest {

    @Test
    public void manualTest() {
        CollectLinks link = new ParseLinksFromPage();
        link.parsePage("https://www.sql.ru/forum/job/9").forEach(System.out::println);
    }

}