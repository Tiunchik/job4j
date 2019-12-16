/**
 * Тестовое задание по созданию обёртки над массивом
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import java.util.Arrays;
import java.util.Random;

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
        items[this.position] = item;
        this.position++;
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
        int index = this.indexOf(id);
        if (index != -1) {
            return items[index];
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
            System.arraycopy(this.items, index + 1, this.items, index, this.position - index);
            items[this.position--] = null;
            return true;
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
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
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
            this.items[index].setName(item.getName());
            return true;
        }
        return false;
    }
}

