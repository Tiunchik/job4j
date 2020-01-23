/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.list;

/**
 * Класс LifeStackList - класс коллекция-стэк. Организован по принципу - LIFO, наследует от класса SimpleLinkedList
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 06.01.2019
 */
public class LifeStackList<E> extends SimpleLinkedList<E> {
    /**
     * Конструкотр класса
     */
    public LifeStackList() {
        super();
    }

    /**
     * Вытащить последний элемент из стека и удалить его в стеке
     *
     * @return последий добавлнный элемент
     */
    public E poll() {
        return delete();
    }

    /**
     * Добавляет элемент в начало стека
     *
     * @param value значение добавляемого элемента
     */
    public void push(E value) {
        add(value);
    }
}
