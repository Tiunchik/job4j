/**
 * Учебное задание по поиску выйгрышного значения в игре сокобан
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.array;

/**
 * Класс для метода по поиску выйгрышного значения в игре сокобан
 * (поиск ряда или строки с одинаковыми значениями)
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.3
 * @since 08.12.2019
 */
public class MatrixCheck {

    /**
     * Метод должен находить ряд или столбец заполненный знаками Х
     *
     * @param board - массив, в котором производится поиск
     * @return логическое значение, 1 - если ряд из Х есть и 0 - если непрерывного ряда или строки из х нету
     */
    public static boolean isWin(char[][] board) {
        for (int row = 0, column = 0; row < board.length && column < board.length; row++, column++) {
            if (board[row][column] == 'X') {
                int count1 = 0, count2 = 0;
                for (int i = 0; i < board.length; i++) {
                    if (board[i][column] != 'X') {
                        count1++;
                    }
                    if (board[row][i] != 'X') {
                        count2++;
                    }
                }
                if (count1 == 5 && count2 == 5) {
                    return true;
                }
            }
            System.out.println();
        }
        return false;
    }

    /**
     * метод main
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        char[][] hasWinVertical = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean win = isWin(hasWinVertical);
        System.out.println("A board has a winner : " + win);
        System.out.println();

        char[][] hasWinHor = {
                {'_', '_', '_', '_', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
        };
        boolean winHor = isWin(hasWinHor);
        System.out.println("A board has a winner : " + winHor);
        System.out.println();

        char[][] notWin = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean lose = isWin(notWin);
        System.out.println("A board has a winner : " + lose);

    }
}
