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
 * @since 27.01.2019
 */
public class Converter {
    /**
     * Удаляет дубликаты пользоватлей на основе повторения электронных адресов
     *
     * @param base - изначальная база пользователей
     * @return - отсортрованная база без дубликатов
     */
    public static List<User> converter(List<? extends User> base) {
        Map<User, Set<String>> mapBase = new HashMap<>();
        Map<String, User> mapTemp = new HashMap<>();

        for (var user : base) {
            for (var emails : user.getEmails()) {
                if (mapTemp.containsKey(emails)) {
                    mapTemp.put(emails, mapTemp.get(emails));
                } else {
                    mapTemp.put(emails, user);
                }
            }
        }

        for (var email : mapTemp.keySet()) {
            var x = mapTemp.get(email);
            if (mapBase.containsKey(x)) {
                mapBase.get(x).add(email);
            } else {
                Set<String> temp = new HashSet<>();
                temp.add(email);
                mapBase.put(x, temp);
            }
        }
        return mapBase.keySet().stream().map(e -> new User(e.getName(), e.getEmails())).collect(Collectors.toList());
    }
}

