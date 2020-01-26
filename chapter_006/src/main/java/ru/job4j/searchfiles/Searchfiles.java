package ru.job4j.searchfiles;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Searchfiles {

    public static void main(String[] args) {
        Conditions condit = new Conditions();
        condit.get(args);
        condit = new Inform().discussion(condit, (() -> {
            Scanner next = new Scanner(System.in);
            return next.nextLine();
        }));
        List<Path> temp = new Search().start(condit);
        new Output().saveLog(temp, condit);
        System.out.println("Работа программы завершена, закройте пожалуйста программу");
    }
}
