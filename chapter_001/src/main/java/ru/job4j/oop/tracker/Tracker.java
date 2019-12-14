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
 * @version 0.2
 * @since 15.12.2019
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
        return Arrays.copyOf(this.items, this.position);
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
        for (int mainCircle = 0; mainCircle < this.position; mainCircle++) {
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
        for (int mainCircle = 0; mainCircle < this.position; mainCircle++) {
            if (this.items[mainCircle].getId().equals(id)) {
                temp = this.items[mainCircle];
                break;
            }
        }
        return temp;
    }

    /**
     * Метод удаляет позицию массива items и производит сортировку массива, в первой части, до индекса position
     * содержатся только переменные имеющие ссылки на объекты
     *
     * @param id - по данному идентификатору ищется позиция. которю необходимо удалить
     */
    public void deleteById(String id) {
        Item temp = null;
        for (int mainCircle = 0; mainCircle < this.position; mainCircle++) {
            if (this.items[mainCircle].getId().equals(id)) {
                this.items[mainCircle] = null;
            }
            if (this.items[mainCircle] == null) {
                int smallCircle = mainCircle + 1;
                for (; smallCircle < this.position; smallCircle++) {
                    if (this.items[smallCircle] != null) {
                        this.items[mainCircle] = this.items[smallCircle];
                        this.items[smallCircle] = null;
                    }
                }
            }
        }
        this.position--;
    }
}

