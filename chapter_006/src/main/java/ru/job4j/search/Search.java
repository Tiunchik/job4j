package ru.job4j.search;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс Search - класс содержит метод поиска файлов по расширению
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 19.01.2020
 */
public class Search {

    public List<File> files(String parent, List<String> exts) {
        File current = new File(parent);
        LinkedList<File> base = new LinkedList<>();
        LinkedList<File> answer = new LinkedList<>();
        if (current.isDirectory()) {
            base.add(current);
        }
        while (!base.isEmpty()) {
            current = base.removeFirst();
            if (current.isDirectory()) {
                answer.addAll(Arrays.asList(current
                        .listFiles(e -> exts.contains(e.getName().substring(e.getName().lastIndexOf(".") + 1)))));
                base.addAll(Arrays.asList(current.listFiles()));
            }
        }
        return answer;
    }


    public String trimExts(File file) {
        return file.getName().substring(file.getName().lastIndexOf(".") + 1);
    }
}
