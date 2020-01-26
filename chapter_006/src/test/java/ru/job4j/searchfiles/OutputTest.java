package ru.job4j.searchfiles;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OutputTest {

    private File root;
    private File first;

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        root = tempFolder.getRoot();
        first = tempFolder.newFile("test.txt");
    }

    @Test
    public void saveLog() {
        String[] args = ("-d " + root.getAbsolutePath() + " -o " + root.getAbsolutePath() + "log.txt").split(" ");
        Conditions temp = new Conditions();
        temp.get(args);
        List<Path> list = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        list.add(first.toPath());
        List<String> expected = new Output().saveLog(list, temp);
        try (BufferedReader in = new BufferedReader(new FileReader(root.getAbsolutePath() + "log.txt"))) {
            in.lines().forEach(answers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expected, answers);
    }
}