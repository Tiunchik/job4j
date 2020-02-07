package ru.job4j.magnit;

import static org.junit.Assert.*;

import org.junit.Test;
import ru.job4j.psqltrackering.TrackerSQL;

import static org.hamcrest.Matchers.is;

public class TrackerSQLTest {

    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }

}