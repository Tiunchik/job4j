/**
 * Тестовый сервер для провеки работы IDEA
 *
 * @author Maksim Tiunchik
 */

package ru.job4j.anotherserver;


import java.io.*;
import java.net.*;

/**
 * Класс Server - Тестовый сервер для провеки работы IDEA
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 30.01.2020
 */
public class Server {

    public static void main(String[] args)  {
        try (ServerSocket server = new ServerSocket(3345)) {
            Socket client = server.accept();
            PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String str;
            System.out.println("Сервер запущен");
            while (!server.isClosed()) {
                str = "test";
                out.println(str);
                System.out.println("Пользоватлю направлено test");
                str = in.readLine();
                System.out.println("Пользоватль написал " + str);
                if (str.equals("by")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
