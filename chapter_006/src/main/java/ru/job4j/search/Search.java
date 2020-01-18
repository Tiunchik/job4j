package ru.job4j.search;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Search {

    public List<File> files(String parent, List<String> exts) {
        File current = new File(parent);
        LinkedList<File> base = new LinkedList<>();
        LinkedList<File> answer = new LinkedList<>();
        if (current.isDirectory()) {
            base.addAll(Arrays.asList(current.listFiles()));
        }
        while (!base.isEmpty()) {
            current = base.removeFirst();
            if (current.isDirectory()) {
                base.addAll(Arrays.asList(current.listFiles()));
            }
            if (current.isFile() && exts.contains(trimExts(current))) {
                answer.add(current);
            }
        }
        return answer;
    }


    public String trimExts(File file) {
        return file.getName().substring(file.getName().lastIndexOf(".") + 1);
    }
}
