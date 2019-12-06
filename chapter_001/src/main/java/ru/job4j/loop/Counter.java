package ru.job4j.loop;

public class Counter {

    public static int add(int start, int finish) {
        int result = 0;
            if (start<finish) {
                for (int i = start;i <= finish; i++) {
                    if (i % 2 == 0) {
                        result  += i;
                    }
                }
            }
            else {
                for (int i = finish;i <= start; i++) {
                    if (i % 2 == 0) {
                        result  += i;
                    }
                }
            }
            return result;
        }
    }
