/**
 * Пакет для работы с IO
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.analizy;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс Analizy - учебный клас для загрузки файда, обработки и выгркзки иотгоо в новый файл
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 18.01.2020
 */
public class Analizy {
    public void unavailable(String source, String target) {
        List<String> temp;
        try (BufferedReader sour = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            temp = sour.lines().collect(Collectors.toCollection(LinkedList::new));
            var stage = true;
            for (var e : temp) {
                if (stage && (e.startsWith("400") || e.startsWith("500"))) {
                    out.write(e.substring(e.indexOf("00") + 3));
                    out.write(";");
                    stage = false;
                } else if (!stage && !(e.startsWith("400") || e.startsWith("500"))) {
                    out.write(e.substring(e.indexOf("00") + 3));
                    out.write(";");
                    out.write("\n");
                    stage = true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unavailable(File source, File target) {
        this.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
    }
}