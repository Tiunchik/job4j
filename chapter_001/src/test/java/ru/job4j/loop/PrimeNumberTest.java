package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PrimeNumberTest {
    @Test
    public void when5() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(5);
        assertThat(count, is(3));
    }

    @Test
    public void when11() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(11);
        assertThat(count, is(5));
    }

    @Test
    public void when2() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(2);
        assertThat(count, is(1));
    }

    @Test
    public void when71() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(71);
        assertThat(count, is(20));
    }

    @Test
    public void when173() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(173);
        assertThat(count, is(40));
    }
}