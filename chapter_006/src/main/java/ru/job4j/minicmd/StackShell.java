/**
 * Пакет ru.job4j.minicmd для эмуляции методов командной строки
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.minicmd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс StackShell - test class for exam.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 05.03.2020
 */
public class StackShell {
    private static final Logger LOG = LogManager.getLogger(StackShell.class.getName());

    /**
     * emulation of root folder.
     */
    private Folder root;
    /**
     * current folder for work.
     */
    private Folder position;

    /**
     * constructor, set emulations of folders.
     */
    StackShell() {
        root = new Folder(null, "root");
        Folder usr = new Folder(root, "usr");
        Folder local = new Folder(usr, "local");
        Folder lib = new Folder(root, "lib");
        position = root;
    }

    /**
     * primari and singular method of class - emulates work of cd function in termonal
     *
     * @param path put string comand for terminal here
     * @return this stackShell
     */
    StackShell cd(final String path) {
        return execute(path, true);
    }

    /**
     * execute moving into virtual file system
     *
     * @param action string comand, can combine differetn command together (like ../usr)
     * @param rigth always true - for main start, and false for inner start, keep fro SOF
     * @return this stackshell witn new value of position
     */
    private StackShell execute(String action, boolean rigth) {
        StackShell temp = this;
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
            position = position.leafs.stream()
                    .filter(e -> e.name.equals(action))
                    .findFirst()
                    .orElse(position);
        } else if (rigth) {
            StringBuilder command = new StringBuilder();
            LinkedList<String> tempChar = new LinkedList<>();
            for (var e : action.toCharArray()) {
                tempChar.add(0, e + "");
            }
            while (!tempChar.isEmpty()) {
                var e = tempChar.removeLast();
                if (e.equalsIgnoreCase("/")) {
                    temp = execute(command.toString(), false);
                    command = new StringBuilder();
                    continue;
                }
                command.append(e);
            }
            temp = execute(command.toString(), false);
        }
        return temp;
    }

    /**
     * return corrent value of position.
     *
     * @return return corrent value of position
     */
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

    /**
     * class emulates folders of file system for visiting.
     */
    static class Folder {
        /**
         * link to parrent of folder
         */
        Folder parent;
        /**
         * name of folder
         */
        String name;
        /**
         * childrens of folder - another folders
         */
        List<Folder> leafs = new ArrayList<>();

        /**
         * constructor of folder
         *
         * @param parent set patent folder
         * @param name set name of folder
         */
        public Folder(Folder parent, String name) {
            this.parent = parent;
            this.name = name;
            if (parent != null) {
                this.parent.leafs.add(this);
            }
        }
    }

}
