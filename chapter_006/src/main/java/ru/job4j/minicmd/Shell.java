/**
 * Пакет для работы с IO, эмуляция методов командной строки
 *
 * @author Maksim Tiunchik
 */

package ru.job4j.minicmd;

import java.io.*;
import java.nio.file.*;

/**
 * Класс Shell - эмуляция методов командной строки
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 30.01.2020
 */
public class Shell {

    private static final String SEP = System.getProperty("file.separator");
    private static final String WIN = "/";

    private Path root;
    private Path position;
    private boolean asserts = false; //А надо делать ассертсы, если и так JUnit тестирует программу?

    public Shell(String[] args) {
        for (var e : args) {
            if (e.equalsIgnoreCase("-ea")) {
                asserts = true;
            } else {
                root = Paths.get(e);
                if (!Files.isDirectory(root)) {
                    root = Path.of(new File("").getAbsolutePath());
                }
            }
        }
        position = root;
    }

    public Shell() {
        root = Paths.get("");
        position = root;
    }


    Shell cd(final String path) {
        if (path.equals(SEP)) {
            position = root;
        } else if (path.equals("..")) {
            if (position != root) {
                position = position.getParent();
            }
        } else if (path.matches("^[a-zA-Z_0-9]*$")) {
            try {
                position = Files.walk(position, 1, FileVisitOption.FOLLOW_LINKS)
                        .filter(e -> e.getFileName().toString().equals(path))
                        .findFirst().orElse(position);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (path.matches("/*\\w+/*")) {
            String tempPath = path;
            while (tempPath.startsWith(SEP) || tempPath.startsWith(WIN)) {
                cd(SEP);
                tempPath = tempPath.substring(1);
            }
            while (tempPath.endsWith(SEP) || tempPath.endsWith(WIN)) {
                cd(SEP);
                tempPath = tempPath.substring(0, tempPath.length() - 1);
            }
            cd(tempPath);
        }
        return this;
    }

    public String path() {
        String str = SEP;
        if (root != position) {
            Path temp = position.subpath(root.getNameCount(), position.getNameCount());
            str += temp.toString();
        }
        return str;
    }
}
