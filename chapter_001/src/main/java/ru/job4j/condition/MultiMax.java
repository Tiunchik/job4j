package ru.job4j.condition;

public class MultiMax {

    public int max(int first, int second, int third) {
        int temp;
        temp = (first > second) ? first : second;
        return (temp > third) ? temp : third;
    }

}
