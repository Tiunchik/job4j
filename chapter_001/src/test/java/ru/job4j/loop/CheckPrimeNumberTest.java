package ru.job4j.loop;

import org.junit.Test;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CheckPrimeNumberTest {
    @Test
    public void when5() {
        boolean rsl = CheckPrimeNumber.isItPrime(5);
        assertThat(rsl, is(true));
    }

    @Test
    public void when4() {
        boolean rsl = CheckPrimeNumber.isItPrime(4);
        assertThat(rsl, is(false));
    }

    @Test
    public void when2() {
        boolean rsl = CheckPrimeNumber.isItPrime(2);
        assertThat(rsl, is(true));
    }

    @Test
    public void when117() {
        boolean rsl = CheckPrimeNumber.isItPrime(117);
        assertThat(rsl, is(false));
    }

    @Test
    public void when119() {
        boolean rsl = CheckPrimeNumber.isItPrime(119);
        assertThat(rsl, is(false));
    }

    @Test
    public void when173() {
        boolean rsl = CheckPrimeNumber.isItPrime(173);
        assertThat(rsl, is(true));
    }

}