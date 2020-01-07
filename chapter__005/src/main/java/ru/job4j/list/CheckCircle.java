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
 * @version 0.1
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
        Node current = check;
        Node last = current.next;
        while (last != null) {
            if (last == last.next) {
                return true;
            }
            while (current != last) {
                if (current == last.next) {
                    return true;
                }
                current = current.next;
            }
            last = last.next;
            current = check;
        }
        return false;
    }
}
