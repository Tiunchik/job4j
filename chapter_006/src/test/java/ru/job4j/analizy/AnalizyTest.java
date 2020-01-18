package ru.job4j.analizy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Класс AnalizyTest - набор тестов для класса Analizy
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 18.01.2020
 */
public class AnalizyTest {

    private List<String> temp;
    private File where;
    private File answer;

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();


    @Before
    public void setUp() throws Exception {
        where = tempFolder.newFile("test.check");
        temp = new ArrayList<>(List.of(
                "200 10:56:01",
                "500 10:57:01",
                "400 10:58:01",
                "200 10:59:01",
                "500 11:01:02",
                "200 11:02:02"
        ));
        try (BufferedWriter out =
                     new BufferedWriter(new OutputStreamWriter(
                             new FileOutputStream(where)))) {
            for (String s : temp) {
                out.write(s);
                out.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something go incorrectly");
        }
    }

    @Test
    public void wheWeTryWithTemp() throws IOException {
        answer = tempFolder.newFile("answer.check");
        Deque<String> test = new LinkedList<>();
        Analizy an = new Analizy();
        an.unavailable(where, answer);
        try (BufferedReader out =
                     new BufferedReader(new FileReader(
                             answer))) {
            out.lines().forEach(test::add);
        } catch (
                IOException e) {
            e.printStackTrace();
            System.out.println("Something reading incorrectly");
        }
        assertEquals(test.removeFirst(), "10:57:01;10:59:01;");
        assertEquals(test.removeFirst(), "11:01:02;11:02:02;");
    }
}