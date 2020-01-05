package ru.job4j.lambda.group;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Group {

    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream()
                .flatMap(e -> e.getUnits().stream()
                        .map(x -> new Holder(x, e.getName())))
                .collect(
                        Collectors.groupingBy(t -> t.key,
                                Collector.of(
                                        HashSet::new,
                                        (e, x) -> {
                                            e.add(x.value);
                                        },
                                        (left, right) -> {
                                            left.addAll(right);
                                            return left;
                                        })));
    }

    static class Holder {
        String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

}
