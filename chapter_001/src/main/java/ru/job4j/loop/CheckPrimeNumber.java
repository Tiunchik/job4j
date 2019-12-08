package ru.job4j.loop;

public class CheckPrimeNumber {

    public static boolean isItPrime(int victim) {
        boolean simple = true;
        if (victim < 2) {
            simple = false;
        } else {
            for (int i = 2; i < victim; i++) {
                if (victim % i == 0) {
                    simple = false;
                }
            }
        }
        return simple;
    }
}

