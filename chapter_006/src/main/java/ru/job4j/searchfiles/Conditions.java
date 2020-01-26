package ru.job4j.searchfiles;

import java.util.regex.Pattern;

public class Conditions {
    /*
     Программа должна собираться в jar и запускаться через java -jar find.jar -d c:/ -n *.txt -m -o log.txt
Ключи
-d - директория в которая начинать поиск.
-n - имя файл, маска, либо регулярное выражение.
-m - искать по макс, либо -f - полное совпадение имени. -r регулярное выражение.
-o - результат записать в файл.
     */

    private String directory = "c:/";
    private String condition = ".*";
    private String result = "result.txt";
    private Pattern pattern;
    private boolean mask = false;
    private boolean fullmatch = false;
    private boolean regular = false;


    public void get(String[] args) {
        String check = "";
        for (int index = 0; index < args.length; index++) {
            if (args[index].matches("^-.+$")) {
                check = args[index];
                switch (check) {
                    case ("-m"):
                        mask = true;
                        break;
                    case ("-f"):
                        fullmatch = true;
                        break;
                    case ("-r"):
                        regular = true;
                        break;
                    default:
                        break;
                }
                continue;
            }
            switch (check) {
                case ("-d"):
                    directory = args[index];
                    break;
                case ("-n"):
                    condition = args[index];
                    break;
                case ("-o"):
                    if (args[index].length() > 0) {
                        result = args[index];
                    }
                    break;
                default:
                    break;
            }
        }
        makePattern();
    }

    private void makePattern() {
        int x = 0;
        if (mask) {
            if (condition.startsWith("*")) {
                condition = "." + condition;
            }
            if (condition.endsWith("*")) {
                condition = condition.substring(0, condition.length() - 1) + ".*";
            }
            pattern = Pattern.compile(condition);
            x++;
        }
        if (fullmatch) {
            pattern = Pattern.compile("^" + condition + "$");
            x++;
        }
        if (regular) {
            pattern = Pattern.compile(condition);
            x++;
        }
        if (x > 1 || x == 0) {
            pattern = Pattern.compile(".*");
        }
    }

    public String getDirectory() {
        return directory;
    }

    public String getResult() {
        return result;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
