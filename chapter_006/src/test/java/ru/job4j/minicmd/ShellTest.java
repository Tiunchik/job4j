/**
 * Пакет для работы с IO, эмуляция методов командной строки
 *
 * @author Maksim Tiunchik
 */

package ru.job4j.minicmd;


import org.junit.Test;

import java.io.File;


import static org.junit.Assert.*;

/**
 * Класс ShellTest - тест эмуляция методов командной строки
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 30.01.2020
 */
public class ShellTest {

    private static final String SEP = System.getProperty("file.separator");

    @Test
    public void testAllFunctions() {
        File root = new File(System.getProperty("java.io.tmpdir") + "/root");
        root.mkdir();
        File first = new File(root + "/job4j/chapter_001");
        first.mkdirs();
        File sevond = new File(root + "/job4jJun");
        sevond.mkdir();

        String[] args = {"-ea", root.toString()};
        Shell cmd = new Shell(args);

        assertEquals(SEP, cmd.path());

        cmd.cd("job4j").cd("chapter_001");
        cmd.cd("../local").cd("./");
        assertEquals(SEP + "job4j" + SEP + "chapter_001", cmd.path());

        cmd.cd("..");
        assertEquals(SEP + "job4j", cmd.path());

        cmd.cd("//job4jJun///");
        assertEquals(SEP + "job4jJun", cmd.path());

    }
}