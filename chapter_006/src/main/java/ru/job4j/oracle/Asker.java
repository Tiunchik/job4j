/**
 * Пакет для работы с IO, создание сетевого бота
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oracle;

import java.io.*;
import java.net.*;

/**
 * Класс Asker - класс клиент сервера
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 25.01.2020
 */
public class Asker {

    public void client(Socket clientScoket, Input input) {
        try (PrintWriter out = new PrintWriter(clientScoket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientScoket.getInputStream()))) {
            String str = "";
            do {
                while (in.readLine().isEmpty()) { // не понимаю как сдлать эот пункт нормально, если делать через isEmpty то не работает тест, если через ready - плохо работает в реальности
                    str = in.readLine();
                    System.out.println(str);
                }
                str = "";
                while (str.equals("")) {
                    str = input.answer();
                }
                out.println(str);
            } while (!"пока".equalsIgnoreCase(str));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try {
            new Asker().client(new Socket(InetAddress.getByName("192.168.31.217"), 1987), new ConsoleInput());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
