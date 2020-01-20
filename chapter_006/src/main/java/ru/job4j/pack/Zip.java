package ru.job4j.pack;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void pack(File source, File target, String direct) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath().substring(source.getPath().lastIndexOf(direct))));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.getPath()))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    List<File> seekBy(String root, List<String> exts) {
        File current = new File(root);
        LinkedList<File> base = new LinkedList<>();
        LinkedList<File> answer = new LinkedList<>();
        if (current.isDirectory()) {
            base.addAll(Arrays.asList(current.listFiles()));
            while (!base.isEmpty()) {
                current = base.removeFirst();
                if (current.isDirectory()) {
                    base.addAll(Arrays.asList(current.listFiles()));
                }
                if (current.isFile()) {
                    if (!(exts.contains(current.getName().substring(current.getName().lastIndexOf(".") + 1)))) {
                        answer.add(current);
                    }
                }
            }
        }
        return answer;
    }

    void pack(List<File> sources, File target, String direct) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (var source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath().substring(direct.length() + 1)));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.getPath()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
