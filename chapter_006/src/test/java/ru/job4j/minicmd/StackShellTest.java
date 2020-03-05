/**
 * Пакет ru.job4j.minicmd для эмуляции методов командной строки
 *
 * @author Maksim Tiunchik
 */

package ru.job4j.minicmd;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Класс StackShellTest - test for shell class made with stack list
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 05.03.2020
 */
public class StackShellTest {


    @Test
    public void testAllFunctions() {

        final StackShell shell = new StackShell();

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