package ru.job4j.time;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Time {

    public String getTime() {
        String answer = null;
        try (Socket timeSocket = new Socket("time-a.timefreq.bldrdoc.gov", 13)) {
            InputStream inn = timeSocket.getInputStream();
            Scanner in = new Scanner(inn);
            while (in.hasNextLine()) {
                answer = in.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    public static void main(String[] args) {
        String test = new Time().getTime();
        System.out.println(test);
    }
}
