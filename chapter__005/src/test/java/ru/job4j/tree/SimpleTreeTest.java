/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author -
 */
package ru.job4j.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SimpleTreeTest {

    @Test
    public void when6ElFindLastThen6() {
        SimpleTree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        SimpleTree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    /**
     * тест ученика
     *
     * @author Maksim Tiunchik
     */
    @Test
    public void whenWeUseIterator() {
        SimpleTree<Integer> tree = new SimpleTree<>(1);
        tree.add(null, 2);
        tree.add(null, 3);
        tree.add(null, 4);
        tree.add(2, 8);
        tree.add(2, 9);
        tree.add(2, 10);
        tree.add(3, 11);
        tree.add(3, 12);
        tree.add(3, 13);
        tree.add(4, 14);
        Iterator<Integer> it = tree.iterator();
        var expected = 0;
        while (it.hasNext()) {
            it.next();
            expected++;
        }
        assertEquals(expected, tree.size());
    }

    /**
     * тест ученика
     *
     * @author Maksim Tiunchik
     */
    @Test(expected = NoSuchElementException.class)
    public void whenExeptionNext() {
        SimpleTree<Integer> tree = new SimpleTree<>(1);
        tree.add(null, 2);
        tree.add(null, 3);
        tree.add(null, 4);
        Iterator<Integer> it = tree.iterator();
        while (it.next() != null) {
            it.next();

        }
    }

    /**
     * тест ученика
     *
     * @author Maksim Tiunchik
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenTreeWasCorrected() {
        SimpleTree<Integer> tree = new SimpleTree<>(1);
        tree.add(null, 2);
        tree.add(null, 3);
        tree.add(null, 4);
        Iterator<Integer> it = tree.iterator();
        it.next();
        tree.add(null, 5);
        it.next();
    }

    /**
     * тест ученика
     *
     * @author Maksim Tiunchik
     */
    @Test
    public void whenTryToAddTheSame() {
        SimpleTree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        assertFalse(tree.add(1, 4));
    }

    /**
     * тест ученика
     *
     * @author Maksim Tiunchik
     */
    @Test
    public void isntTreeBinary() {
        SimpleTree<Integer> tree = new SimpleTree<>(1);
        tree.add(null, 2);
        tree.add(null, 3);
        tree.add(2, 8);
        tree.add(2, 9);
        tree.add(2, 10);
        tree.add(3, 11);
        tree.add(3, 12);
        assertFalse(tree.isBinary());
    }

    /**
     * тест ученика
     *
     * @author Maksim Tiunchik
     */
    @Test
    public void isTreeBinary() {
        SimpleTree<Integer> tree = new SimpleTree<>(1);
        tree.add(null, 3);
        tree.add(null, 2);
        tree.add(2, 8);
        tree.add(2, 9);
        tree.add(3, 12);
        assertTrue(tree.isBinary());
    }
}

