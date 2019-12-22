/**
 * Тестовое задание по работе с жадным алгоритмом
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.test;

import java.util.Arrays;
/**
 * Класс CofeMachine - эмулирует работу аппарата по возврату сдачи
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 22.12.2019
 */
public class CofeMachine {
    /**
     * Массив содержит список возможных монет на сдачу
     */
    private final int[] COINS = {10, 5, 2, 1};

    /**
     * Метод осуществляет подбор сдачи жадным алгоритмом
     *
     * @param money - внесенные деньги за покупку
     * @param price - цена покупки
     * @return - массив монет для возврата сдачи покупателю
     */
    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int charge = money - price;
        while (charge != 0) {
            for (int index = 0; index < COINS.length; index++) {
                if (charge - COINS[index] >= 0) {
                    charge -= COINS[index];
                    rsl[size++] = COINS[index];
                    break;
                }
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}
