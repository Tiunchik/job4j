/**
 * Пакет для работы/учёбы с коллекциями.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.search;

import java.util.ArrayList;

/**
 * Класс PhoneDictionary - класс содержит список пользователей и осуществляет поиск по ключевому слову
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 31.12.2019
 */
public class PhoneDictionary {
    /**
     * Массив со списокм пользователей
     */
    private ArrayList<Person> persons = new ArrayList<Person>();

    /**
     * Команда для добавления пользователя в массив
     *
     * @param person - заранее созданный пользователь добавляется в массив пользователей типа ArrayList
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (var check : persons) {
            if (check.getName().contains(key) || check.getSurname().contains(key)
                    || check.getPhone().contains(key) || check.getAddress().contains(key)) {
                result.add(check);
            }
        }
        return result;
    }
}
