package ru.job4j.anotherserver;

import java.io.*;
import java.net.Socket;


public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 3345);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            String str;
            while (!socket.isClosed()) {
                str = in.readLine();
                System.out.println(str);
                str = br.readLine();
                out.println(str);
                if (str.equals("by")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
