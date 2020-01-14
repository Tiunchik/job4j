/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.tree;

import java.util.*;

/**
 * Класс SimpleTree - упрощенный вариант многопутевого дерева
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 11.01.2019
 */
public class SimpleTree<E extends Comparable<E>> implements IntTree<E> {

    /**
     * корень древа
     */
    private Node<E> root;
    /**
     * количество элментов в дереве
     */
    private int size = 0;
    /**
     * счётчик изменений
     */
    private int modCount = 0;

    public SimpleTree(E root) {
        this.root = new Node<E>(root);
        size++;
    }


    /**
     * вставить значение в дерево, такое значение должно отсутствовать в дереве.
     *
     * @param parent родитель
     * @param child  вставляемое зачение
     * @return 1 - если добавлено, 0 - если нет
     */
    @Override
    public boolean add(E parent, E child) {
        if (findBy(child).isPresent()) {
            return false;
        }
        var temp = findBy(parent);
        if (temp.isPresent()) {
            temp.get().add(new Node<>(child));
            size++;
            modCount++;
            return true;
        }
        return false;
    }

    /**
     * Количество узлов в дереве
     *
     * @return количество узлов в дереве
     */
    public int size() {
        return size;
    }

    /**
     * получить счётчик изменеий
     *
     * @return получить счётчик изменеий
     */
    public int getModCount() {
        return modCount;
    }

    /**
     * Поиск узла в дереве
     *
     * @param value - поиск по значению
     * @return возвращает ссылку на значение
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }


    /**
     * Информирует, дерево бинарное или нет
     *
     * @return 1 - если бинарное, 0 - если нет
     */
    public boolean isBinary() {
        var temp = new LinkedList<>(List.of(root));
        Node<E> current;
        while (temp.size() != 0) {
            current = temp.pollFirst();
            if (current.leaves().size() > 2) {
                return false;
            }
            temp.addAll(current.leaves());
        }
        return true;
    }


    /*
            for(E e :this) {
            if (findBy(e).get().leaves().size() > 2) {
                return false;
                    }
                }
                    return true;
            }
    */
    private List<Node<E>> proseed(Node<E> root) {
        return new LinkedList<>(root.leaves());
    }
/*
    private boolean isBinary(Node<E> temp) {
        var rsl = true;
        List<Node<E>> list = temp.leaves();
        int b = list.size(), i = 0;
        rsl = list.size() < 3;
        while (b > i && rsl) {
            rsl = isBinary(list.get(i++));
        }
        return rsl;
    }
*/

    /**
     * Итератор
     *
     * @return возвращает итератор
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private final List<Node<E>> children = new ArrayList<>(100);
            private int position = 0;
            private int modified = getModCount();
            private Node<E> current = null;
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (children.size() <= position) {
                    collectList();
                }
                return children.size() > position;
            }

            @Override
            public E next() {
                if (children.size() <= position) {
                    collectList();
                }
                if (modified != getModCount()) {
                    throw new ConcurrentModificationException("Tree was modificated");
                }
                if (!hasNext()) {
                    throw new NoSuchElementException("Tree is expired");
                }
                return children.get(position++).getValue();
            }

            private void collectList() {
                if (current == null) {
                    children.add(root);
                    current = root;
                } else {
                    while (children.size() <= position && index < children.size()) {
                        current = children.get(index++);
                        children.addAll(current.leaves());
                    }
                }
            }
        };
    }
}
