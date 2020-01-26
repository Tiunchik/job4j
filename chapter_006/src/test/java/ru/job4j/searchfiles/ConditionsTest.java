package ru.job4j.searchfiles;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;

public class ConditionsTest {

    @Test
    public void whenAllWrittenCorrectly() {
        String[] args = "-d c:/ -n *.txt -m -o log.txt".split(" ");
        Conditions temp = new Conditions();
        temp.get(args);
        Assert.assertEquals("c:/", temp.getDirectory());
        Assert.assertEquals(".*.txt", temp.getPattern().toString());
        Assert.assertEquals("log.txt", temp.getResult());
    }

    @Test
    public void whenPatternHasMistakes() {
        String[] args = "-d c:/ -n *.txt -m -r -o log.txt".split(" ");
        Conditions temp = new Conditions();
        temp.get(args);
        Assert.assertEquals("c:/", temp.getDirectory());
        Assert.assertEquals(".*", temp.getPattern().toString());
        Assert.assertEquals("log.txt", temp.getResult());
    }

    @Test
    public void whenthereIsntResultName() {
        String[] args = "-d c:/ -n *.txt -m -r ".split(" ");
        Conditions temp = new Conditions();
        temp.get(args);
        Assert.assertEquals("c:/", temp.getDirectory());
        Assert.assertEquals(".*", temp.getPattern().toString());
        Assert.assertEquals("result.txt", temp.getResult());
    }

    @Test
    public void whenAlsoThereIsntdirectory() {
        String[] args = "c:/ -n *.txt -m -r ".split(" ");
        Conditions temp = new Conditions();
        temp.get(args);
        Assert.assertEquals("c:/", temp.getDirectory());
        Assert.assertEquals(".*", temp.getPattern().toString());
        Assert.assertEquals("result.txt", temp.getResult());
    }
}