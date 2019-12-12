package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMax2Test {

    @Test
    public void testSqMac1() {
        assertThat(SqMax2.max(5, 4, 6, 2), is(6));
    }

    @Test
    public void testSqMac2() {
        assertThat(SqMax2.max(12, 4, 3, 10), is(12));
    }

    @Test
    public void testSqMac3() {
        assertThat(SqMax2.max(5, 12, 6, 2), is(12));
    }

    @Test
    public void testSqMac4() {
        assertThat(SqMax2.max(5, 7, 6, 12), is(12));
    }

}

