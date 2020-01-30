/**
 * Пакет для программы поиска файлов
 *
 * @author Maksim Tiunchik
 */

package ru.job4j.searchfiles;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Класс Conditions - извлечение значний из args
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 30.01.2020
 */
public class Conditions {
    /*
     Программа должна собираться в jar и запускаться через java -jar find.jar -d c:/ -n *.txt -m -o log.txt
Ключи
-d - директория в которая начинать поиск.
-n - имя файл, маска, либо регулярное выражение.
-m - искать по макс, либо -f - полное совпадение имени. -r регулярное выражение.
-o - результат записать в файл.
     */

    private Pattern pattern;
    private Map<String, String> base = new HashMap<>();

    public void get(String[] args) {
        String key = "";
        for (var e : args) {
            if (e.matches("^-.+$")) {
                key = e;
            }
            base.put(key, e);

        }
        makePattern();
    }

    private void makePattern() {
        String temp = base.get("-n");
        int x = 0;
        if (base.get("-m") != null) {
            if (temp.startsWith("*")) {
                temp = "." + temp;
            }
            if (temp.endsWith("*")) {
                temp = temp.substring(0, temp.length() - 1) + ".*";
            }
            pattern = Pattern.compile(temp);
            x++;
        }
        if (base.get("-f") != null) {
            pattern = Pattern.compile("^" + temp + "$");
            x++;
        }
        if (base.get("-r") != null) {
            pattern = Pattern.compile(temp);
            x++;
        }
        if (x > 1 || x == 0) {
            pattern = Pattern.compile(".*");
        }
    }

    public String getDirectory() {
        String temp = base.get("-d");
        if (temp == null) {
            temp = "c:/";
        }
        return temp;
    }

    public String getResult() {
        String temp = base.get("-o");
        if (temp == null) {
            temp = "result.txt";
        }
        return temp;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
