package ru.job4j.searchfiles;

import java.io.Console;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.function.Supplier;

public class Inform {

    public Conditions discussion(Conditions terms, Supplier<String> in) {
        String str;
        Conditions answer = terms;
        //Scanner console = new Scanner(System.in);
        System.out.println("Уважаемый ползователь!");
        do {
            System.out.println("Вами введены следующие параметры для работы программы:");
            System.out.println("Поиск в директории: " + answer.getDirectory());
            System.out.println("Поиск по условию:" + answer.getPattern().toString());
            System.out.println("Сохранение информации о результатах поиска в файл: " + answer.getResult());
            System.out.println("Если необходимо внести изменения, то пожалуйста введите N, если запрос введён верно, то ведите Y");
            str = in.get();
            if ("n".equalsIgnoreCase(str)) {
                System.out.println("Пожалуйста введите новый запрос, начиная с указателя -d, со следующмии условями:");
                System.out.println("-d - директория в которая начинать поиск.\n"
                        + "-n - имя файла, маска, либо регулярное выражение.\n"
                        + "-m - искать по маcке\n"
                        + "-f - искать по полному совпадению имени\n"
                        + "-r - искать по регулярному выражению.\n"
                        + "-o - результат записать в файл.");
                str = in.get();
                answer.get(str.split(" "));
            }
        }
        while (!"y".equalsIgnoreCase(str));
        return answer;
    }
}
