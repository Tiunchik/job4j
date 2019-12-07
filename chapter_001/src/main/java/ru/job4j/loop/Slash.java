/**
 * Slash
 * author Maksim Tiunchik
 */

package ru.job4j.loop;

/**
 * класс Slash предназачен для рисования в виде буквы Х
 * @author Maksim Tiunchik (Senebh@gmail.com)
 * @since 07.12.2019
 * @version 1
 */
public class Slash {

    /**
     * Метод draw рисует символ Х в консоли из цивры 0
     * @param size - данная переменная задаёт размер символа по вертикали и горизонтали
     *             в символах
     */
    public static void draw(int size) {
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                boolean left = (row == cell);
                boolean right = (row + cell == size-1 && row != cell);
                if (left) {
                    System.out.print("0");
                } else if (right) {
                    System.out.print("0");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * main - используеться для вывода псевдографики с помощью метода draw
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Draw by 3");
        draw(3);
        System.out.println("Draw by 5");
        draw(5);
        System.out.println("Draw by 9");
        draw(9);
    }
}