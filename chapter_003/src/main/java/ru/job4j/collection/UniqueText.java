/**
 * Пакет для работы/учёбы с коллекциями.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Класс UniqueText - класс содержит метод сравнения идентичности текста
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 31.12.2019
 */
public class UniqueText {
    /**
     * метод сравнения идентичности текста
     *
     * @param originText - базовый текст
     * @param duplicateText - сравнивамый текст
     * @return - логичное значение, 1 - да иднтичны/похожи, 2 - нет, разные
     */
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = false;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>(Arrays.asList(origin));
        var count = 0;
        if (check.containsAll(Arrays.asList(text))) {
            rsl = true;
        } else {
            for (String temp : text) {
                if (check.contains(temp)) {
                    count++;
                }
            }
        }
        if (count > Math.ceil(check.size() * 0.7)) {
            rsl = true;
        }
        return rsl;
    }
}
