/**
 * Пакет для работы с коллекциями, тестовое задание Почта
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.mail;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс Converter - содержит метод по преобразование списка пользователей.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.3
 * @since 16.02.2019
 */
public class Converter {
    /**
     * Удаляет дубликаты пользоватлей на основе повторения электронных адресов
     *
     * @param base - изначальная база пользователей
     * @return - отсортрованная база без дубликатов
     */
    public static List<User> converter(List<? extends User> base) {
        Map<String, Set<String>> tempList = new HashMap<>();
        Map<String, User> tempMap = new HashMap();
        User key;
        for (var us : base) {
            key = us;
            for (var em : us.getEmails()) {
                if (tempMap.containsKey(em)) {
                    key = tempMap.get(em);
                    break;
                }
            }
            User finalKey = key;
            tempMap.putAll(us.getEmails().stream().collect(Collectors.toMap(e -> e, x -> finalKey)));
        }
        String tempText;
        for (var e : tempMap.keySet()) {
            tempText = tempMap.get(e).getName();
            if (!tempList.containsKey(tempText)) {
                tempList.put(tempText, new HashSet<String>());
            }
            if (tempList.containsKey(tempText)) {
                tempList.get(tempText).add(e);
            }
        }
        List<User> answer = new ArrayList<>();
        for (var e : tempList.keySet()) {
            answer.add(new User(e, tempList.get(e)));
        }
        return answer;
    }
}

