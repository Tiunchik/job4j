package ru.job4j.converter;

import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {

    @Test
    public void rubleToEuro() {
        int in = 140;
        int expected = 2;
        int out = Converter.rubleToEuro(in);
        Assert.assertEquals(expected, out);

    }

    /*
    public static int rubleToDollar(int i){
        return -1;
    }

    Сохранил не работающий метод. в целом - если ссылаться на верный класс - Converter - то тест проходиться на ура,
    из-за этого при прохождении урока мне изначалньо вывело, что всё правильно, так как если делать по примеру TrackStudio -
    сылаешься на коректный метод
    @Test
    public void rubleToDollar () {
        int in = 180;
        int expected = 3;
        int out = СonverterTest.rubleToDollar(in);
        Assert.assertEquals(expected,out);
    }
    */
    @Test
    public void rubleToDollar() {
        int in = 180;
        int expected = 3;
        int out = Converter.rubleToDollar(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void euroBackRuble() {
        int in = 3;
        int expected = 210;
        int out = Converter.euroBackRuble(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void dollarBackRuble() {
        int in = 10;
        int expected = 600;
        int out = Converter.dollarBackRuble(in);
        Assert.assertEquals(expected, out);
    }
}

/*
если запустить вконце прогон всего класа, то он проводит тест по всем отмеченным @Test методам. возможно стоит тоже
упомянуть в лекции, мне такой момент сделал всё более понятным
 */
