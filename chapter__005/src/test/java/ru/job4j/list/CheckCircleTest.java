/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Класс CheckCircleTest - класс тест провеки работы меотда определяюещго зацикленность связанного списка
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 07.01.2019
 */
public class CheckCircleTest {

    @Test
    public void whenHasCircle() {

        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertTrue(CheckCircle.hasCircle(first));
    }

    @Test
    public void whenHasNotCircle() {

        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertFalse(CheckCircle.hasCircle(first));
    }

    @Test
    public void whenHasElementToItselfNext() {

        Node first = new Node(1);
        Node two = new Node(2);

        first.next = two;
        two.next = two;
        assertTrue(CheckCircle.hasCircle(first));
    }

    @Test
    public void whenHasOneElement() {

        Node first = new Node(1);

        first.next = first;
        assertTrue(CheckCircle.hasCircle(first));
    }

    @Test
    public void whenSecontLinkToFirst() {

        Node first = new Node(1);
        Node two = new Node(2);

        first.next = two;
        two.next = first;
        assertTrue(CheckCircle.hasCircle(first));
    }
}