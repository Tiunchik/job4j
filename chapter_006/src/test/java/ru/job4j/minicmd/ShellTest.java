/**
 * Пакет ru.job4j.minicmd для эмуляции методов командной строки
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
 * @version 0.2
 * @since 09.02.2020
 */
public class ShellTest {


    @Test
    public void testAllFunctions() {

        final Shell shell = new Shell();

        assertEquals("/", shell.path());

        shell.cd("/");
        assertEquals("/", shell.path());

        shell.cd("usr/..");
        assertEquals("/", shell.path());

        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        assertEquals("/usr/local", shell.path());

        shell.cd("..");
        assertEquals("/usr", shell.path());

        shell.cd("//lib///");
        assertEquals("/lib", shell.path());
    }
}