package ru.job4j.loop;

public class Fitness {

    public static int whoBetter (int i, int y) {
        int mounth =0;
        while (i < y) {
            i *= 3;
            y *= 2;
            mounth++;
        }
        return mounth;
    }
}
