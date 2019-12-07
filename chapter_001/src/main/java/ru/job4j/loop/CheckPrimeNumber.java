package ru.job4j.loop;

public class CheckPrimeNumber {

    public static boolean isItPrime(int victim) {
        boolean simple = true;
        if (victim != 2 && victim != 3 && victim != 5 && victim != 7){
            for (int i = 2; i < victim; i++) {
                if (victim % i == 0) {
                    simple = false;
                }
            }
        }
        return simple;
    }

}

