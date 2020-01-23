/**
 * Пакет для работы с коллекциями/итератором/генериками
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.iterator.generic.store;

/**
 * Абстрактный класс Base - модель данных
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 05.01.2019
 */
public abstract class Base {
    /**
     * Индивидуалньый номер модели данных
     */
    private final String id;

    /**
     * конструктор модели анных
     *
     * @param id - задаваемый индивидуальный номер
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * метод геттер для индивидуального номера
     *
     * @return - возвращает индивидуальный номер объекта
     */
    public String getId() {
        return id;
    }
}
