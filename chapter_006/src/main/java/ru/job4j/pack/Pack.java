package ru.job4j.pack;

import java.io.File;
import java.util.List;

public class Pack {

    public static void main(String[] args) {
        Args ar = new Args(args);
        if ((new File(ar.directory()).isDirectory())) {
            Zip zp = new Zip();
            List<File> tempList = zp.seekBy(ar.directory(), ar.excule());
            if (tempList.size() > 0) {
                zp.pack(tempList, new File(ar.directory() + "/" + ar.output()), ar.directory());
            } else {
                System.out.println("Error. No files for zipping");
            }
        } else {
            System.out.println("Error. Incorrect directory");
        }
    }
}


