/**
 * Тестовое задание по созданию обёртки над массивом
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import java.util.*;

/**
 * Класс Traker - обёрта над массивом ArrayList, имеет методы работы с данным массивом
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.3
 * @since 23.12.2019
 */
public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final ArrayList<Item> items = new ArrayList<Item>();

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random korea = new Random();
        return String.valueOf(System.currentTimeMillis() + korea.nextLong());
    }

    /**
     * Метод возвращает массив содержащий все не пустые ячейки типа Item, обрезация лишние ячейки
     *
     * @return массив заполненный всеми не пустыми ячейками массива tracker.item[]
     */
    public Item[] findAll() {
        int index = 0;
        Item[] rsl = new Item[items.size()];
        for (Item temp : items) {
            rsl[index++] = temp;
        }
        return rsl;
    }

    /**
     * Метод возвращает массив содержащий все ячейки типа  Item поле name которых содержит определённое значение
     *
     * @param key - клечевое слово по которому производиться поиск
     * @return массив заполненный объектами типа Item поле name которых содержит значение key
     */
    public Item[] findByName(String key) {
        Item[] array = new Item[items.size()];
        int smallCircle = 0;
        for (Item temp : items) {
            if (temp.getName().equals(key)) {
                array[smallCircle++] = temp;
            }
        }
        array = Arrays.copyOf(array, smallCircle);
        return array;
    }

    /**
     * Массив возвращает ссылку на объект по идивидуальному номеру объекта id
     *
     * @param id - номер по которому производиться поиск
     * @return - возвращает ссылку на найденный объект
     */
    public Item findById(String id) {
        int index = this.indexOf(id);
        if (index != -1) {
            return items.get(index);
        } else {
            return null;
        }
    }

    /**
     * Метод удаляет позицию массива items и производит сортировку массива, в первой части, до индекса position
     * содержатся только переменные имеющие ссылки на объекты
     *
     * @param id - по данному идентификатору ищется позиция, которю необходимо удалить
     */
    public boolean deleteById(String id) {
        int index = this.indexOf(id);
        if (index != -1) {
            items.remove(index);
        }
        return false;
    }

    /**
     * Метод поиска индекса позиции по ID
     *
     * @param id - по аргменту данного параметра ищут индекс заявки
     * @return - индекс зявки в массиве items
     */
    private int indexOf(String id) {
        int rsl = -1;
        int index = 0;
        for (Item temp : items) {
            if (temp.equals(id)) {
                rsl = index;
                break;
            }
            index++;
        }
        return rsl;
    }

    /**
     * Метод замены зявки по ID номеру
     *
     * @param id в данный параметр необходимо передовать ID номер заявки, которую неоходимо зменить
     */
    public boolean replace(String id, Item item) {
        int index = this.indexOf(id);
        if (index != -1) {
            items.get(index).setName(item.getName());
            return true;
        }
        return false;
    }

    /**
     * Метод сортировки ArraнList items
     *
     * @param x true - по порядку, else - в обратном порядке
     */
    public void sorter(boolean x, Tracker tracker) {
        ArrayList<Item> temp = new ArrayList<Item>(tracker.items);
        if (x) {
            Collections.sort(temp, new SortTrackerUp()); //can be replaised list sort
            tracker.items.clear();
            tracker.items.addAll(temp);
        } else {
            Collections.sort(temp, new SortTrackerDown());
            tracker.items.clear();
            tracker.items.addAll(temp);
        }
    }
}


