/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.list;

/**
 * Класс SimpleLinkedList - класс коллекция-стэк. Организован по принципу - LIFO
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 06.01.2019
 */
public class SimpleLinkedList<E> {
    /**
     * Количество элементов в коллекции
     */
    private int size;
    /**
     * Последний объект добавленный в коллекцию, первый на возращение
     */
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Метод возвращает из списка последнее добавленной значение, удаляя его из списка
     */
    public E delete() {
        Node<E> delNode = this.first;
        this.first = this.first.next;
        this.size--;
        return delNode.data;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}

