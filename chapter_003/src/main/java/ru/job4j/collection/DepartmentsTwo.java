/**
 * Пакет для тестового задания по сортировке и работе со списками "отортровать департаменты"
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Класс Departments - предназначен для работы с коллекциями типа лист, имеет методы сортировки
 * а так же специальный метод поиска прорущенных департаментов
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 29.12.2019
 */
public class DepartmentsTwo {
    /**
     * Метод заполнения коллекции попущенными наименованиями департаментов
     *
     * @param deps - список деапртаментов
     * @return - откорректированый список департаметов
     */
    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (start.equals("")) {
                    tmp.add(el);
                    start += el;
                } else {
                    tmp.add(start + "/" + el);
                    start += "/" + el;
                }
            }
        }
        ArrayList<String> answer = new ArrayList<>(tmp);
        sortAsc(answer);
        return answer;
    }

    /**
     * Метод сортировки списка типа Стринг в естественном порядке
     *
     * @param orgs - ввдимая для сортировки коллекция
     */
    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    /**
     * Метод сортировки списка типа Стринг в обратном естественному порядке
     *
     * @param orgs - ввдимая для сортировки коллекция
     */
    public static void sortDesc(List<String> orgs) {
        orgs.sort((o1, o2) -> {
            char[] charLeft = o1.toCharArray(), charRight = o2.toCharArray();
            int board = o1.length() - o2.length() >= 0 ? o2.length() : o1.length();
            for (int index = 0; index < board; index++) {
                if (Character.compare(charRight[index], charLeft[index]) != 0) {
                    return Character.compare(charRight[index], charLeft[index]);
                }
            }
            return o1.length() - o2.length();
        });
    }

}