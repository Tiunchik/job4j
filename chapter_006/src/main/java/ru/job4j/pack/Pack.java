package ru.job4j.pack;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Pack {

    public static void main(String[] args) {
        one:
        {
            Args ar = new Args(args);
            if (!(new File(ar.directory()).isDirectory())) {
                System.out.println("Error. Incorrect directory");
                break one;
            }
            Zip zp = new Zip();
            List<File> tempList = zp.seekBy(ar.directory(), ar.excule());
            if (tempList.size() == 0) {
                System.out.println("Error. No files to zip");
                break one;
            }
            zp.pack(tempList, new File(ar.directory() + "/" + ar.output()), ar.directory());
        }
    }
}

