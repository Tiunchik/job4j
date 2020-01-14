/**
 * Пакет для работы с коллекциями, тестовое задание Почта
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.mail;

import java.util.*;

/**
 * Класс Converter - содержит метод по преобразование списка пользователей.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 14.01.2019
 */
public class Converter {
    /**
     * Удаляет дубликаты пользоватлей на основе повторения электронных адресов
     *
     * @param base - изначальная база пользователей
     * @return - отсортрованная база без дубликатов
     */
    public static List<User> converter(Collection<? extends User> base) {
        List<User> respond = new ArrayList<>(base);
        Set<String> tempSet;
        User xi, xj;
        int x = respond.size();
        for (int i = 0; i < x; i++) {
            xi = respond.get(i);
            for (int j = 0; j < x; j++) {
                xj = respond.get(j);
                if (hasSameElemets(xi, xj)) {
                    tempSet = new HashSet<>(xi.getEmails());
                    tempSet.addAll(xj.getEmails());
                    respond.set(i, new User(xi.getName(), tempSet));
                    respond.remove(j);
                    j--;
                    x--;
                }
            }
        }
        return respond;
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

