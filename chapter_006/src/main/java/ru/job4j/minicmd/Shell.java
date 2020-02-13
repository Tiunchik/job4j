/**
 * Пакет ru.job4j.minicmd для эмуляции методов командной строки
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.minicmd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Shell - эмуляция методов командной строки
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 13.02.2020
 */
public class Shell {
    private static final Logger LOG = LogManager.getLogger(Shell.class.getName());

    private Folder root;
    private Folder position;

    Shell() {
        root = new Folder(null, "root");
        Folder usr = new Folder(root, "usr");
        Folder local = new Folder(usr, "local");
        Folder lib = new Folder(root, "lib");
        position = root;
    }

    Shell cd(final String path) {
        return execute(path, true);
    }

    private Shell execute(String action, boolean rigth) {
        Shell temp = this;
        if (action.matches("/{2,5}.*")) {
            temp = execute("/", false);
        }
        if (action.equals("/")) {
            position = root;
        } else if (action.equals("..")) {
            if (position != root) {
                position = position.parent;
            }
        } else if (action.matches("^[a-zA-Z_0-9]*$")) {
            position = position.leafs.stream().filter(e -> e.name.equals(action)).findFirst().orElse(position);
        } else if (rigth) {
            String command = "";
            char[] tempChar = action.toCharArray();
            for (var e : tempChar) {
                if (e == '/') {
                    temp = execute(command, false);
                    command = "";
                    continue;
                }
                command = command + e;
            }
            temp = execute(command, false);
        }
        return temp;
    }

    public String path() {
        Folder temp = position;
        StringBuilder answer = new StringBuilder();
        if (temp == root) {
            answer.insert(0, "/");
        }
        while (temp != root) {
            answer.insert(0, temp.name);
            answer.insert(0, "/");
            temp = temp.parent;
        }
        return answer.toString();
    }


    static class Folder {
        Folder parent;
        String name;
        List<Folder> leafs = new ArrayList<>();

        public Folder(Folder parent, String name) {
            this.parent = parent;
            this.name = name;
            if (parent != null) {
                this.parent.leafs.add(this);
            }
        }

        private Folder() {
        }
    }

}
