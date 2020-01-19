package ru.job4j.pack;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Pack {

    public static void main(String[] args) {
        Args ar = new Args(args);
        Zip zp = new Zip();
        List<File> tempList = zp.seekBy(ar.directory(), ar.excule());
        zp.pack(tempList, new File(ar.directory() + "/" + ar.output()), ar.directory());
    }
}
