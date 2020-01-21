/**
 * Пакет для работы с IO, создание консольного чата
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.chat;

import org.junit.Test;
import org.junit.Assert;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс ChatTest - комплексный тест работы бота
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 21.01.2020
 */
public class ChatTest {

    @Test
    public void whenWeTestnormalChatWork() {
        File answer = new File(System.getProperty("java.io.tmpdir") + "/answers.txt");
        List<String> tempList = new ArrayList<>(List.of(
                "Как дела",
                "И я так могу",
                "Возможно",
                "А когда мы пойдем тусить",
                "Ты никогда меня не понимал"
        ));
        try (BufferedWriter out = new BufferedWriter(new FileWriter(answer))) {
            for (var e : tempList) {
                out.write(e);
                out.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Input questions = new TestInput(new String[]{"1", "2", "3", "стоп"});
        List<String> out = new ArrayList<>();
        new Chat().startChat(System.getProperty("java.io.tmpdir"), questions, out::add);
        Assert.assertEquals(4, out.size());
        try (BufferedReader in = new BufferedReader(
                new FileReader(System.getProperty("java.io.tmpdir") + "/log.txt"))) {
            out = in.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(8, out.size());
    }
}