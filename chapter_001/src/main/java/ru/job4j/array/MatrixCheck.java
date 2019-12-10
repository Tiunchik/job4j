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
 * @version 0.5
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
        for (short bigCircle = 0; bigCircle < board.length; bigCircle++) {
            if (board[bigCircle][bigCircle] == 'X') {
                short countWin1 = 0, countWin2 = 0;
                for (short smallCircle = 0; smallCircle < board.length; smallCircle++) {
                    if (board[smallCircle][bigCircle] == 'X') {
                        countWin1++;
                    }
                    if (board[bigCircle][smallCircle] == 'X') {
                        countWin2++;
                    }
                }
                if (countWin1 == board.length || countWin2 == board.length) {
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
