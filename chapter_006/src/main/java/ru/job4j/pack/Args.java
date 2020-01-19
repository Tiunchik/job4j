package ru.job4j.pack;

import java.util.ArrayList;
import java.util.List;

public class Args {

    private String directory;
    private List<String> exts = new ArrayList<>();
    private String out;

    public Args(String[] args) {
        String check = "";
        for (int index = 0; index < args.length; index++) {
            check = args[index].equals("-d") ? "-d" : args[index].equals("-e") ? "-e" : args[index].equals("-o") ? "-o" : check;
            if (!args[index].equals("-d") && check.equals("-d")) {
                directory = args[index];
            }
            if (!args[index].equals("-e") && check.equals("-e")) {
                exts.add(args[index].substring(args[index].lastIndexOf(".") + 1));
            }
            if (!args[index].equals("-o") && check.equals("-o")) {
                out = args[index];
            }
        }
    }

    public String directory() {
        return directory;
    }

    public List<String> excule() {
        return exts;
    }

    public String output() {
        return out;
    }
}
