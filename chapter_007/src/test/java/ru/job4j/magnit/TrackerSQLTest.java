package ru.job4j.magnit;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.psqltrackering.TrackerSQL;

import static org.hamcrest.Matchers.is;

/**
 * Класс TrackerSQLTest - будет использован для тестов трекера с базой данной в виде SQL сервера.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 08.02.2020
 */
public class TrackerSQLTest {

    @Ignore
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }

}