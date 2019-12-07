package ru.job4j.loop;

public class Mortgage {

    public int enslavement(int amount, int salary, double percent){
        int years =0;
        double up = percent/100;
        while (amount>0){
            years++;
            amount = amount + (int)(amount*up) - salary;
        }
        return years;
    }

}
