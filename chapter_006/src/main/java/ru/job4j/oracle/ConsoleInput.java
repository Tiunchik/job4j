/**
 * Пакет для работы с IO, создание сетевого бота
 *
 * @author Maksim Tiunchik
 */

package ru.job4j.oracle;

import java.io.IOException;
import java.util.Scanner;

/**
 * Класс ConsoleInput - класс реализует считывание с консоли
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 25.01.2020
 */
public class ConsoleInput implements Input {

    private Scanner temp = new Scanner(System.in);

    @Override
    public String answer() throws IOException {
        return temp.nextLine();

    }

}
