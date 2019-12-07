package ru.job4j.loop;

public class Factorial {

    public static int multiplyAndMultiply (int i) {
        int result = 0;
        if (i>0) {
            result = 1;
            for (int circle = 1; circle <= i; circle++) {
                result *= circle;
            }
        }
        return result;
    }

}
