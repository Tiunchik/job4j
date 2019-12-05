package ru.job4j.condition;

public class Point {
    static double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }

    public static void main(String[] args) {
        double x = distance(5,4,2,1);
        System.out.println("Расстояние между точками равно " + x);
        x =distance(26,34,10,18);
        System.out.println("Расстояние между точками равно " + x);
        x = distance(126,143,15,84);
        System.out.println("Расстояние между точками равно " + x);
        x=distance(10,15,124,46);
        System.out.println("Расстояние между точками равно " + x);
    }

}
