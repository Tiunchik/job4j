package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MortgageTest {
    @Test
    public void when1Year() {
        Mortgage mortgage = new Mortgage();
        int year = mortgage.enslavement(1000, 1200, 1);
        assertThat(year, is(1));
    }

    @Test
    public void when2Year() {
        Mortgage mortgage = new Mortgage();
        int year = mortgage.enslavement(100, 120, 50);
        assertThat(year, is(2));
    }

    @Test
    public void when4Year() {
        Mortgage mortgage = new Mortgage();
        int year = mortgage.enslavement(110, 120, 100);
        assertThat(year, is(4));
    }
}