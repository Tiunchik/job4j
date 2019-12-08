package ru.job4j.condition;

public class Triangle {

    public static boolean exist(double sx, double sy, double sz) {
        return (((sx + sy > sz) && (sx + sz > sy)) && (sy + sz > sx));
    }
}
