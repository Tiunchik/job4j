/**
 * Учебный класс для проверки однорадности заполнения линейного массива типа boolean
 *
 * @author Maksim Tiunchik (Senebh@mail.com
 */
package ru.job4j.array;

/**
 * Класс для осуществелния провеки однородности массива
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 08.12.2019
 */
public class Check {
    /**
     * Метод для провеки однородности массива типа boolean
     *
     * @param data - параметр метода - массив типа boolean, который проверяеться на однородность
     * @return - возвращаемое значение типа boolean, если 1 - то массив однороден, если 0 - то не однороден
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0] != data[i]) {
                result = false;
            }
        }
        return result;
    }
}