package ru.job4j.condition;

public class SqMax2 {
    public static int max(int first, int second, int third, int forth) {
        int result = forth;
        if (first > second) {
            if (first > third) {
                if (first > forth) {
                    result = first; //поменял 3 на 1
                }
            }
            else if (third > forth) { //скопировал часть кода
                result = third;
            }
        }
        else if (second > third) {
            if (second > forth) {
                result = second; //поменял 3 на 2
            }
            }
            else if (third > forth) {
                result = third; //поменял 2 на 3
            }

        return result;
    }
}