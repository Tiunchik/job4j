package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {

    @Test
    public void testFactorialFrom5 (){
        int out = Factorial.multiplyAndMultiply(5);
        assertThat(out, is(120));
    }

    @Test
    public void testFactorialFrom1 (){
        int out = Factorial.multiplyAndMultiply(1);
        assertThat(out, is(1));
    }

    @Test
    public void testFactorialFrom10 (){
        int out = Factorial.multiplyAndMultiply(10);
        assertThat(out, is(3628800));
    }




}
