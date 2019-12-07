package ru.job4j.loop;

public class Mortgage {

    public int enslavement(int amount, int salary, double percent){
        int years =0;
        while (amount>0){
            years++;
            amount +=(int)(amount*(percent/100));
            amount -=salary;
        }
        return years;
    }

}
