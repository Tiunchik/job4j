package ru.job4j.cache;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileSoftKeeperTest {

    @Test
    public void whenWeDontHaveFileInCacheButHaveInFolderThenWeReceiveFile() throws IOException {
        String path = System.getProperty("java.io.tmpdir");
        if (!Files.exists(Paths.get(path + "/New.txt"))) {
            var file = Files.createFile(Paths.get(path + "/New.txt"));
            BufferedWriter temp = Files.newBufferedWriter(file);
            temp.write("123123123123");
            temp.flush();
        }
        FileSoftKeeper testKeeper = new FileSoftKeeper(path);

        String expected = "123123123123";

        String actual = testKeeper.get("New.txt");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whenWeDontHaveFileInCacheAnDontHaveInFolderThenWeReceiveNull() throws IOException {
        String path = System.getProperty("java.io.tmpdir");
        FileSoftKeeper testKeeper = new FileSoftKeeper(path);

        String expected = "file isn't found";

        String actual = testKeeper.get("unrealfile.txt");

        Assert.assertEquals(expected, actual);
    }
}