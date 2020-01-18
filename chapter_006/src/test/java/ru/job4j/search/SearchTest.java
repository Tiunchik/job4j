package ru.job4j.search;


import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void whenWeTryFindTXT() throws Exception {
        File root = new File(System.getProperty("java.io.tmpdir") + "/root");
        root.mkdir();
        File first = new File(root.getAbsolutePath() + "/first");
        first.mkdir();
        new File(root.getAbsolutePath() + "/text.java").createNewFile();
        new File(root.getAbsolutePath() + "/text.exe").createNewFile();
        new File(root.getAbsolutePath() + "/text.data").createNewFile();
        new File(first.getAbsolutePath() + "/text.java").createNewFile();
        new File(first.getAbsolutePath() + "/text.exe").createNewFile();
        new File(first.getAbsolutePath() + "/text.data").createNewFile();
        List<File> answer = new Search().files(root.getAbsolutePath(), new ArrayList<>(List.of("java", "data")));
        assertEquals(4, answer.size());
    }

}