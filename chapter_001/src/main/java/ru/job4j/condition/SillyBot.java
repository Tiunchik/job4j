package ru.job4j.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SillyBot {

    public static String answer(String question) { //IDEA жалуеться при анализе, private-puиlic
        String rsl = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rsl ="До скорой встречи.";
        }
        return rsl;
    }

    /*
    public static String answer(String s1) throws IOException {
        //никогда не использовал switch, потестил, заставляет везде вызывать throws IOException
        String s2;
        switch (s1) {
            case ("Привет, Бот."):
                s2="Привет, умник.";
                break;
            case ("Пока."):
                s2="До скорой встречи.";
                break;
            default:
                s2="Это ставит меня в тупик. Задайте другой вопрос.";
        }
        return s2;
    }
    */
    public static void main(String[] args) throws IOException { //readLine так же вызвает Исключения
        String line;
        //начинал на джавараш, надресировали с Buffered, сканером ни разу не пользовался
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        line = reader.readLine();
        System.out.println(SillyBot.answer(line));
    }
}
