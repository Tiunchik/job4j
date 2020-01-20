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
 * @version 0.2
 * @since 20.01.2019
 */
public class Converter {
    /**
     * Удаляет дубликаты пользоватлей на основе повторения электронных адресов
     *
     * @param base - изначальная база пользователей
     * @return - отсортрованная база без дубликатов
     */
    public static List<User> converter(List<? extends User> base) {
        Map<User, User> respond = new HashMap<>(base.stream().collect(Collectors.toMap(e -> e, x -> x)));
        Set<String> tempSet;
        for (var up : base) {
            if (respond.containsKey(up)) {
                for (var down : base) {
                    if (hasSameElemets(respond.get(up), down)) {
                        respond.remove(down);
                        respond.remove(up);
                        tempSet = new HashSet<>(up.getEmails());
                        tempSet.addAll(new HashSet<>(down.getEmails()));
                        respond.put(up, new User(up.getName(), tempSet));
                    }
                }
            }
        }

        return new ArrayList<>(respond.values());
    }

    /**
     * внутренний меотд сравнния баз телефонов
     *
     * @param o1 - первая база
     * @param o2 - вторая база
     * @return 1 - если есь дубликаты. 0 - если нет
     */
    private static boolean hasSameElemets(User o1, User o2) {
        Set<String> temp = new HashSet<>(o1.getEmails());
        temp.addAll(o2.getEmails());
        return temp.size() != (o1.getEmails().size() + o2.getEmails().size()) && !o1.equals(o2);
    }
}

