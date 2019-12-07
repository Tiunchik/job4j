package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FitnessTest {
    @Test
    public void whenIvanGreatNik() {
        Fitness fit = new Fitness();
        int month = fit.whoBetter(95, 90);
        assertThat(month, is(0));
    }

    @Test
    public void whenIvanLessByOneNik() {
        Fitness fit = new Fitness();
        int month = fit.whoBetter(90, 95);
        assertThat(month, is(1));
    }

    @Test
    public void whenIvanLessByFewNik() {
        Fitness fit = new Fitness();
        int month = fit.whoBetter(50, 90);
        assertThat(month, is(2));
    }

    @Test
    public void whenNikisTerminator() {
        Fitness fit = new Fitness();
        int month = fit.whoBetter(50, 290);
        assertThat(month, is(5));
    }
}