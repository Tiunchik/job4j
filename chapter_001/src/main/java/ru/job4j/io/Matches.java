/**
 * Тестовое задание по разработке игры Спички
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

/**
 * Класс Matches - игра в спички, второй игрок - месье Random
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 14.12.2019
 */
public class Matches {

    public String reques(int i) {
        return "На столе " + i + " спичек\nCколько спичек вы забираете?";
    }

    public int chose() {
        Scanner input = new Scanner(System.in);
        int result;
        while (true) {
            result = Integer.valueOf(input.nextLine());
            if (result > 0 && result < 4) {
                break;
            } else {
                System.out.println("Вы ввели неправильное число, повторите:");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Matches match = new Matches();
        int pile = 11;
        Random croupier = new Random();
        String start = "На столе 11 спичек. Что бы выйграть, вы должны забрать последние спички.\n"
                + "Вы можете брать до 3-х спичек за раз, но не меньше 1"
                + "В данной игре вы играете против крупье Random, он очень хитёр";
        System.out.println(start);
        while (pile > 0) {
            System.out.println(match.reques(pile));
            pile -= match.chose();
            if (pile <= 0) {
                System.out.println("Вы выйграли!");
                break;
            }
            pile -= (croupier.nextInt(2) + 1);
            if (pile <= 0) {
                System.out.println("Выйграл крупье, попробуйте еще раз");
                break;
            }
        }
    }
}
