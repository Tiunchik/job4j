package ru.job4j.converter;

public class Сonverter {

    public static int rubleToEuro (int value){
        return value/70;
    }
    public static int rubleToDollar (int value) {
        return value/60;
    }
    public static int euroBackRuble(int value){
        return value*70;
    }
    public static int dollarBackRuble(int value){
        return value*60;
    }

    public static void main(String[] args) {
        int ruble = 420;
        int dollar;
        int euro;
        int testEsimate;

        boolean test;

        euro = rubleToEuro(ruble);
        System.out.println(ruble + " rubles are " + euro + " euro.");
        testEsimate = 6; // 420/70
        System.out.println(ruble + " are " + euro + ". Test result: " + (testEsimate == euro));

        dollar = rubleToDollar(ruble);
        System.out.println(ruble + " rubles are " + dollar + " dollars.");
        testEsimate = 7; // 420/60
        System.out.println(ruble + " are " + dollar + ". Test result: " + (testEsimate == dollar));

        euro = euro+1;
        ruble = euroBackRuble(euro);
        System.out.println(euro + " euro are " + ruble + " ruble");
        testEsimate = 490; //7*70
        System.out.println(euro + " are " + ruble + ". Test result: " + (testEsimate == ruble));

        dollar = dollar +10;
        ruble = dollarBackRuble(dollar);
        System.out.println(dollar + " dollars are " + ruble + " ruble");
        testEsimate = 1020; //17*60
        System.out.println(dollar + " are " + ruble + ". Test result: " + (testEsimate == ruble));


    }

}
