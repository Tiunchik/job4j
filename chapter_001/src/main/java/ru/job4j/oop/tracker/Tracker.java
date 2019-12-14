/**
 * Тестовое задание по созданию обёртки над массивом
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import java.util.Random;
import java.util.Arrays;

/**
 * Класс Traker - обёрта над массивом, иметт мтоды работы с данным массивом
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 14.12.2019
 */
public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

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
        items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random korea = new Random();
        return String.valueOf(korea.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод возвращает массив содержащий все не пустые ячейки типа Item, обрезация лишние ячейки
     *
     * @return массив заполненный всеми не пустыми ячейками массива tracker.item[]
     */
    public Item[] findAll() {
        Item[] array = new Item[this.items.length];
        int smallCircle = 0;
        for (int mainCircle = 0; mainCircle < position; mainCircle++) {
            if (this.items[mainCircle] != null) {
                array[smallCircle++] = this.items[mainCircle];
            }
        }
        array = Arrays.copyOf(array, smallCircle);
        return array;
    }

    /**
     * Метод возвращает массив содержащий все ячейки типа  Item поле name которых содержит определённое значение
     *
     * @param key - клечевое слово по которому производиться поиск
     * @return массив заполненный объектами типа Item поле name которых содержит значение key
     */
    public Item[] findByName(String key) {
        Item[] array = new Item[this.items.length];
        int smallCircle = 0;
        for (int mainCircle = 0; mainCircle < position; mainCircle++) {
            if (this.items[mainCircle].getName().equals(key)) {
                array[smallCircle++] = this.items[mainCircle];
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
        Item temp = null;
        for (int mainCircle = 0; mainCircle < position; mainCircle++) {
            if (this.items[mainCircle].getId().equals(id)) {
                temp = this.items[mainCircle];
            }
        }
        return temp;
    }
}

