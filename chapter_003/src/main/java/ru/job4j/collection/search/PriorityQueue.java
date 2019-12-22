/**
 * Пакет для тестов классов содержащихся в пакете ru.job4j.colliection.search
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.search;

import java.util.LinkedList;
/**
 * Класс PriorityQueue - класс для обучения работе с коллекцией LinkedList
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 22.12.2019
 */
public class PriorityQueue {
    /**
     * Созданная колекция на основе объекта Task
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод организовывает вставку элементов в коллекцию согласно заданного в элементе приоритета
     *
     * @param task - добавляемая в коллекцию позиция
     */
    public void put(Task task) {
        int index = 0;
            for (Task element : tasks) {
                if (element.getPriority() > task.getPriority()) {
                    break;
                }
                index++;
        }
        this.tasks.add(index, task);
    }

    /**
     * Метод забирает верхнпиий элемент из коллекции, удаляя его
     *
     * @return
     */
    public Task take() {
        if (tasks.size() > 0) {
            return tasks.remove(0);
        }
        return new Task("null", 0);
    }
}
