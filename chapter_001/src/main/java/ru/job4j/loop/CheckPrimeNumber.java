package ru.job4j.loop;

public class CheckPrimeNumber {

    public static boolean isItPrime(int victim) {
        int count = 0;
        for (int i = 2; i != 10; i++) {
            if (victim%i == 0 ) {
                count++;
            }
        }
        return (count == 1);
    }

}

