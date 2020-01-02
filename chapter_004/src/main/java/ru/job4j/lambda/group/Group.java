package ru.job4j.lambda.group;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Group {

    public static Map<String, HashSet<String>> sections(List<Student> students) {
        var temp = students.stream()
                .flatMap(e -> e.getUnits().stream()
                        .map(x -> new Holder(e.getName(), x)))
                .collect(
                        Collectors.groupingBy(t -> t.key,
                                Collector.of(
                                        HashSet<String>::new,
                                        (e, x) -> {
                                            e.add(x.value);
                                        },
                                        (left, right) -> {
                                            left.addAll(right);
                                            return left;
                                        })));
        return temp;
    }

    static class Holder {
        String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

}
