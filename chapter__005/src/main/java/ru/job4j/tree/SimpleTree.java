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
     * вставить значение в дерево
     *
     * @param parent родитель
     * @param child  вствляемое зачение
     * @return 1 - если добавлено, 0 если нет
     */
    @Override
    public boolean add(E parent, E child) {
        if (parent != null) {
            var temp = findBy(parent);
            if (temp.isPresent()) {
                if (temp.get().leaves().stream().noneMatch(e -> e.eqValue(child))) {
                    temp.ifPresent(e -> e.add(new Node<E>(child)));
                    size++;
                    modCount++;
                    return true;
                }
            }
        } else {
            root.add(new Node<E>(child));
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
     * @return 1 - если бинарное, 2- если нет
     */
    public boolean isBinary() {
        return isBinary(root);
    }

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

    /**
     * Итератор
     *
     * @return возвращает итератор
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            public final List<Node<E>> children = new ArrayList<>();
            private int positon = 0;
            private int modified = getModCount();

            @Override
            public boolean hasNext() {
                if (children.size() == 0) {
                    collectList(root);
                }
                return children.size() > positon;
            }

            @Override
            public E next() {
                if (children.size() == 0) {
                    collectList(root);
                }
                if (modified != getModCount()) {
                    throw new ConcurrentModificationException("Tree was modificated");
                }
                if (!hasNext()) {
                    throw new NoSuchElementException("Tree is expired");
                }
                return children.get(positon++).getValue();
            }

            private void collectList(Node<E> temp) {
                int i = 0, b = temp.leaves().size();
                while (b > i) {
                    collectList(temp.leaves().get(i++));
                }
                children.add(temp);
            }
        };
    }
}
