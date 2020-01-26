package ru.job4j.searchfiles;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.function.Supplier;

public class InformTest {

    PrintStream myOut = System.out;
    ByteArrayOutputStream baOut;
    PrintStream out;

    @Before
    public void setUp() throws Exception {
        baOut = new ByteArrayOutputStream();
        out = new PrintStream(baOut);
        System.setOut(out);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(myOut);
    }

    @Test
    public void whenUserChouseN() {
        /*
        StringJoiner expected = new StringJoiner("\r\n");
        expected.add("Уважаемый ползователь!");
        expected.add("Вами введены следующие параметры для работы программы:");
        expected.add("Поиск в директории: c:/");
        expected.add("Поиск по условию:.*.txt");
        expected.add("Сохранение информации о результатах поиска в файл: log.txt");
        expected.add("Если необходимо внести изменения, то пожалуйста введите N, если запрос введён верно, то ведите Y");
        expected.add("Пожалуйста введите новый запрос, начиная с указателя -d, со следующмии условями:");
        expected.add("-d - директория в которая начинать поиск.");
        expected.add("-n - имя файла, маска, либо регулярное выражение.");
        expected.add("-m - искать по маcке");
        expected.add("-f - искать по полному совпадению имени");
        expected.add("-r - искать по регулярному выражению.");
        expected.add("-o - результат записать в файл.");
        expected.add("Вами введены следующие параметры для работы программы:");
        expected.add("Поиск в директории: c:/");
        expected.add("Поиск по условию:.*.txt");
        expected.add("Сохранение информации о результатах поиска в файл: log.txt");
        expected.add("Если необходимо внести изменения, то пожалуйста введите N, если запрос введён верно, то ведите Y");
        expected.add("");
        */
        String[] args = "-d c:/ -n *.txt -m -o log.txt".split(" ");
        Conditions temp = new Conditions();
        temp.get(args);
        new Inform().discussion(temp, new Supplier<String>() {

            String[] ansString = {"n", "-d c:/ -n *.txt -m -o log.txt", "y"};
            int index = -1;

            @Override
            public String get() {
                index++;
                return ansString[index];
            }
        });
        int i = (int) Arrays.stream(baOut.toString().split("\n")).count();
        Assert.assertEquals(18, i);
    }
}