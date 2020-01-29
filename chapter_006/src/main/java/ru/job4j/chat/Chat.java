/**
 * Пакет для работы с IO, создание консольного чата
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.chat;

import java.io.*;

import java.util.*;
import java.util.function.Consumer;

/**
 * Класс Chat - основной класс чат-бота
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.3
 * @since 27.01.2020
 */
public class Chat {

    private static final String STOP = "стоп";
    private static final String SEP = System.getProperty("line.separator");

    /**
     * Метод загружает ответы бота из файла
     *
     * @param path путь к ответам
     * @return - список ответов
     * @throws IOException - ловиться в главном метода чата
     */
    public List<String> upload(String path) throws IOException {
        List<String> answer = new ArrayList<>(100);
        try (BufferedReader temp = new BufferedReader(new FileReader(path + "/answers.txt"))) {
            temp.lines().forEach(answer::add);
            return answer;
        }
    }

    /**
     * Сохраняет все сообщения чата
     *
     * @param log  - передаваемый для сохранения список сообщений
     * @param path - путь к файлу с логом
     * @throws IOException - ловиться в главном метода чата
     */
    public void saveLog(List<String> log, String path) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path + "/log.txt"))) {
            for (var e : log) {
                out.write(e);
                out.write(SEP);
            }
        }

    }

    /**
     * Основной метод работы чата, згружает данные, организует диалог с пользователем
     *
     * @param base     - адрес где находиться файл с ответами
     * @param asker    - каким ор\бразом реализуется общние с пользоваталем
     * @param consumer - вывод данных пользователю
     */
    public void startChat(String base, Input asker, Consumer<String> consumer) {
        try {
            List<String> answers = upload(base);
            List<String> log = new LinkedList<>();
            String temp = "";
            while (!temp.equalsIgnoreCase(STOP)) {
                temp = answers.get((int) (Math.random() * answers.size()));
                log.add(temp);
                temp = asker.ask(temp, consumer);
                log.add(temp);
            }
            saveLog(log, base);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
