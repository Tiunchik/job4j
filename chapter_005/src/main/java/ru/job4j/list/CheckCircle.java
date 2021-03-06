/**
 * Пакет для работы с коллекциями, разаботка упрощённых аналогов коллекций
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.list;

/**
 * Класс CheckCircle - класс содержит метод провеки зациклености связанного списка
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 07.01.2019
 */
public class CheckCircle {
    /**
     * Метод провеки зциклености связнноо списка
     *
     * @param check - первый узел для начала проверки
     * @return - 1 если цикл существует, 0 если цикла нет
     */
    public static boolean hasCircle(Node check) {
        Node slow = check;
        Node fast = check;
        while (slow != null && fast != null) {
            if (slow == fast.next) {
                return true;
            }
            if (fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return false;
            }
        }
        return false;
    }
}