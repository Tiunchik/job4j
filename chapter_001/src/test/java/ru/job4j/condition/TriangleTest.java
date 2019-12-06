package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {

    @Test
    public void whenExist() {
        assertThat(Triangle.exist(2.0, 2.0, 2.0), is(true));
        assertThat(Triangle.exist(7.0, 6.0, 5.0), is(true));
    }

    @Test
    public void whenNotExist() {
        assertThat(Triangle.exist(16.0, 2.0, 2.0), is(false));
        assertThat(Triangle.exist(2.0, 16.0, 2.0), is(false));
        assertThat(Triangle.exist(2.0, 2.0, 16.0), is(false));
    }


}