package ru.job4j.searchfiles;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternClass {

    public static void main(String[] args) {

        Pattern answer = Pattern.compile("^-.+$");
        String s = "-d";
        Matcher match = answer.matcher(s);
        System.out.println(match.find());

        Path temp = Path.of("C:\\tools\\apache-maven-3.6.3\\JAVA_Methods_Programming_v2.march2015.pdf");
        System.out.println(temp.getFileName());

        List<Path> list = new ArrayList<>();
        list.add(temp);
        int pos = 1;
        for (var e : list) {
            String str = String.format("|%6d| |%50s| |%-100s|", pos, e.getFileName(), e.toFile().getAbsolutePath());
            System.out.println(str);
            pos++;
        }

    }

}
