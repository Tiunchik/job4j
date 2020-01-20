package ru.job4j.pack;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Pack {

    public static void main(String[] args) {
        Args ar = new Args(args);
        if (ar.directory().length() == 0) {
            System.out.println("Error. Incorrect directory");
            System.exit(0);
        }
        Zip zp = new Zip();
        List<File> tempList = zp.seekBy(ar.directory(), ar.excule());
        if (tempList.size() == 0) {
            System.out.println("Error. No files to zip");
            System.exit(0);
        }
        zp.pack(tempList, new File(ar.directory() + "/" + ar.output()), ar.directory());
    }
}

