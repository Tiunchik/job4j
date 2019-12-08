/**
 * Учебный класс для проверки работы с методом startWith
 *
 * @author Maksim Tiunchik (Senebh@mail.com
 */
package ru.job4j.array;

import java.util.Arrays;
import java.lang.String;


/**
 * Класс для для срвнение массивов типа String методом startWith
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 08.12.2019
 */
public class ArrayChar {
    /**
     * Метод для проведения сравнения двух массивов типа String методом startWith
     *
     * @param word - массив типа char, символы которого проверяються
     * @param pref - масив типа char, на соотвествие с симвлами которого проверяеться массив word
     * @return - возвращаемое значение по итогам проверки, 1 - проверка успешна,  0 - проверка не успешна
     */

    public static boolean startsWith(char[] word, char[] pref) {
        boolean result = true;
        for (int i = 0; i < word.length && i < pref.length; i++) {
            if (!(word[i] == pref[i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
