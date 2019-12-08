/**
 * Учебный класс для эмуляции метода endsWith
 *
 * @author Maksim Tiunchik (Senebh@mail.com
 */
package ru.job4j.array;

/**
 * Класс для осуществелния эмуляции метода endsWith
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 08.12.2019
 */

public class EndsWith {

    /**
     * Метод эмулирующий стандартный метод для типа String - endsWith. Если один из массивов длинее, то сравниваеться только короткая часть.
     *
     * @param word - массив, с последними позициям которого роизводиться сравнение значение
     * @param post - массив, позиции которого сравниваються с позициями первого
     * @return - возвращаемое значение, 1 - если последие позиции равны, 0 - если есть расхождние.
     */
    public static boolean endsWith(char[] word, char[] post) {
        for (int y = word.length - 1, x = post.length - 1; (x >= 0) && (y >= 0); x--, y--) {
            if (word[y] != post[x]) {
                return false;
            }
        }
        return true;
    }
}
