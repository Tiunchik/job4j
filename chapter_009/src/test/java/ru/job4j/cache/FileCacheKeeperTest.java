package ru.job4j.cache;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileCacheKeeperTest {

    @Test
    public void whenWeDontHaveFileInCacheButHaveInFolderThenWeReceiveFile() throws IOException {
        String path = System.getProperty("java.io.tmpdir");
        if (!Files.exists(Paths.get(path + "/New.txt"))) {
            var file = Files.createFile(Paths.get(path + "/New.txt"));
            BufferedWriter temp = Files.newBufferedWriter(file);
            temp.write("123123123123");
            temp.flush();
        }
        FileCacheKeeper testKeeper = new FileCacheKeeper(path);

        String expected = "123123123123";

        String actual = testKeeper.get("New.txt");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whenWeDontHaveFileInCacheAnDontHaveInFolderThenWeReceiveNull() throws IOException {
        String path = System.getProperty("java.io.tmpdir");
        FileCacheKeeper testKeeper = new FileCacheKeeper(path);

        String expected = null;

        String actual = testKeeper.get("unrealfile.txt");

        Assert.assertEquals(expected, actual);
    }
}