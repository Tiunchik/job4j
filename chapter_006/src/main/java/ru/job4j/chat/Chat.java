package ru.job4j.chat;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Chat {

    public List<String> upload(String path) {
        List<String> answer = new ArrayList<>(100);
        try (BufferedReader temp = new BufferedReader(new FileReader(path + "/answers.txt"))) {
            temp.lines().forEach(e -> answer.add(e));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    public void saveLog(List<String> log, String path) {
        try (FileOutputStream out = new FileOutputStream(path + "/log");
             BufferedOutputStream bos = new BufferedOutputStream(out)) {
            for (var e : log) {
                byte[] step = e.getBytes();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startChat(String base) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            PrintStream answer = new PrintStream(System.out);
            answer.println("");
            List<String> answers = upload(base);
            List<String> log = new LinkedList<>();
            String ans = "", temp = "";
            while (!ans.equals("стоп")) {
                ans = reader.readLine();
                log.add(ans);
                temp = answers.get((int) (Math.random() * answers.size()));
                log.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
