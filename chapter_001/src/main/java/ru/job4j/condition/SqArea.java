package ru.job4j.condition;

public class SqArea {
    public static double square(int p, int k) {
        int l, h;
        h = (2 * (k + 1)) / p; //осознал что с алгеброй за какой, 7 класс?, стало както плоховато, вроде верно преобразования составил вычисляя h, но сомневаюсь
        l = h * k;
        return l * h;
    }

    public static void main(String[] args) {
        double answer = square(6, 2);
        System.out.println(" p = 6, k = 2, s = 2, real = " + answer);
        answer = square(4, 1);
        System.out.println(" p = 4, k = 1, s = 1, real = " + answer);
    }

}
