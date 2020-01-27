/**
 * Пакет для работы с IO
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.analizy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс Analizy - учебный клас для загрузки файда, обработки и выгркзки иотгоо в новый файл
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.5
 * @since 27.01.2020
 */
public class Analizy {
    public void unavailable(String source, String target) {
        List<String> temp, answer = new ArrayList<>();
        try {
            temp = Files.readAllLines(Paths.get(source));
            var stage = true;
            var i = 0;
            for (String e : temp) {
                if (stage && (e.startsWith("400") || e.startsWith("500"))) {
                    answer.add(e.substring(e.indexOf("00") + 3) + ";");
                    stage = false;
                } else if (!stage && !(e.startsWith("400") || e.startsWith("500"))) {
                    answer.set(i, answer.get(i) + e.substring(e.indexOf("00") + 3) + ";");
                    stage = true;
                    i++;
                }
            }
            upload(answer, target);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void unavailable(File source, File target) {
        this.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
    }

    private void upload(List<String> answers, String target) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            for (var e : answers) {
                out.write(e);
                out.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
