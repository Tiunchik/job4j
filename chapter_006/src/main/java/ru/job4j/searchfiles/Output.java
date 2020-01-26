package ru.job4j.searchfiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Output {

    public List<String> saveLog(List<Path> list, Conditions terms) {
        System.out.println("Начата запись файла с результатами проверки");
        List<String> tempAnswer = new ArrayList<>();
        try (BufferedWriter out = new BufferedWriter(new FileWriter(terms.getResult()))) {
            int pos = 1;
            String str;
            for (var e : list) {
                str = String.format("|%6d| |%50s| |%-100s|", pos, e.getFileName(), e.toFile().getAbsolutePath());
                out.write(str);
                tempAnswer.add(str);
                pos++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Завершена запись файла с результатами");
        return tempAnswer;
    }

}
