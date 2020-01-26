package ru.job4j.searchfiles;

import org.junit.*;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class SearchTest {

    private File root;

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        root = tempFolder.getRoot();
        tempFolder.newFile("text.txt");
        tempFolder.newFile("answers.txt");
    }

    @Test
    public void whenTestSearchOneDeepDiectory() {
        String[] args = ("-d " + root.getAbsolutePath() + " -o log.txt").split(" ");
        Conditions temp = new Conditions();
        temp.get(args);
        List<Path> answers = new Search().start(temp);
        Assert.assertEquals(2, answers.size());
    }
}