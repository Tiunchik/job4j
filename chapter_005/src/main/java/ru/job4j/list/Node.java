/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.list;

/**
 * Класс Node - класс узел для связанного списка
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.01.2019
 */
class Node<T> {
    /**
     * конструктор узла
     *
     * @param value - значение вносимое в узел
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Значение в узле
     */
    T value;
    /**
     * Ссылка на следующий узел
     */
    Node<T> next;
}
