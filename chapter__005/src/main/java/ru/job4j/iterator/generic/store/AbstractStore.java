/**
 * Пакет для работы с коллекциями/итератором/генериками
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.iterator.generic.store;

import ru.job4j.iterator.generic.SimpleArray;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Класс AbstractStore - асбтрактный класс базы данных класса Base и всех его подклассов
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 05.01.2019
 */
public abstract class AbstractStore<T extends Base> implements Store {
    /**
     * База данных реализована на "коллекции" SimpleArray
     */
    private SimpleArray<T> base;

    public AbstractStore(int size) {
        this.base = new SimpleArray<>(size);
    }

    /**
     * Переопредёлнный метод добавления объектов в базу данных
     *
     * @param model - добавляемый в базу объект
     */
    @Override
    public void add(Base model) {
        this.base.add((T) model);
    }

    /**
     * Переопредёлнный метод замены объекта в базе данных
     *
     * @param id - по данному идентификатору ищется объкет в баз
     * @param model - добавляемый в базу объект
     */
    @Override
    public boolean replace(String id, Base model) {
        Iterator<T> temp = base.iretator();
        int index = 0;
        while (temp.hasNext()) {
            T e = temp.next();
            if (e.getId().equals(id)) {
                base.set(index, (T) model);
                return true;
            }
            index++;
        }
        return false;
    }

    /**
     * Метод удалния объкетв из базы
     *
     * @param id - по данному идентификатору ищется объкет в баз
     * @return  удаляемый из базы объект (заменяется на null)
     */
    @Override
    public boolean delete(String id) {
        Iterator<T> temp = base.iretator();
        int index = 0;
        while (temp.hasNext()) {
            var e = temp.next();
            if (e.getId().equals(id)) {
                base.remove(index);
                return true;
            }
            index++;
        }
        return false;
    }

    /**
     * метод поиса объектов в базе
     *
     * @param id - поиск ведется по данному идентификатору
     * @return - объект возвращается для рабты
     */
    @Override
    public Base findById(String id) {
        Iterator<T> temp = base.iretator();
        int index = 0;
        while (temp.hasNext()) {
            var e = temp.next();
            if (e != null && e.getId().equals(id)) {
                return base.get(index);
            }
            index++;
        }
        return null;
    }
}
