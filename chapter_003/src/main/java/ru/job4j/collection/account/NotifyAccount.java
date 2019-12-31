/**
 * Пакет для работы/учёбы с коллекциями.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.collection.account;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Класс NotifyAccount - класс содержит метод сортировки всего списка счетов только в уникальные (по номеру паспорта)
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 31.12.2019
 */
public class NotifyAccount {
    /**
     * метод сортировки всего списка счетов только в уникальные (по номеру паспорта)
     *
     * @param accounts - массив счетов
     * @return уникальный массив счетов
     */
    public static HashSet<Account> sent(List<Account> accounts) {
        /* согласно условий задачи надо сделать так:
                for (Account temp : accounts) {
            rsl.add(temp);
        }
         */
        return new HashSet<>(accounts);
    }
}
