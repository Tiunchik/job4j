package ru.job4j.anotherserver;


import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args)  {
        try (ServerSocket server = new ServerSocket(3345)) {
            Socket client = server.accept();
            PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
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
