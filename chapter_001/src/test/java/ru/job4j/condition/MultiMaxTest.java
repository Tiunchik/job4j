package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MultiMaxTest {
    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax(); //вначале сдлл метод статичным, но посмотрев на созданный объкет - отменил.
        int result = check.max(1, 4, 2);
        assertThat(result, is(4)); //занимателньая конструкция, смысл в целом понятен, надеюсь где то дальше будет поподробнее
        result = check.max(16, 7, 24);
        assertThat(result, is(24));
    }
}