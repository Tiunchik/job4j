/**
 * Пакет для тестового задания по сортировке и работе со списками "отортровать департаменты"
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection;


import java.util.*;

/**
 * Класс Departments - предназначен для работы с коллекциями типа лист, имеет методы сортировки
 * а так же специальный метод поиска прорущенных департаментов
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 28.12.2019
 */
public class Departments {
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
                } else  {
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
        orgs.sort(new DepDescComp());
    }

}