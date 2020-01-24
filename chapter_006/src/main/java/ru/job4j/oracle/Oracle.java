/**
 * Пакет для работы с IO, создание сетевого бота
 *
 * @author Maksim Tiunchik
 */

package ru.job4j.oracle;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;
import java.util.logging.*;
import java.util.stream.Collectors;

/**
 * Класс Oracle - класс-сервер
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 25.01.2020
 */
public class Oracle {

    private List<String> load(Path path) throws IOException {
        return Files.newBufferedReader(path).lines().filter(e -> e.length() > 0).collect(Collectors.toList());
    }

    public void starServer(Socket server, Path answers) {
        Logger log = log(Level.OFF);
        String ask = "";
        try (PrintWriter out = new PrintWriter(server.getOutputStream(), true);
             Scanner in = new Scanner(server.getInputStream())) {
            List<String> answer = load(answers);
            log.log(Level.FINE, "Server downloaded answers");
            out.println("Приветствую! Я знаю много умных фраз, спроси меня!");
            out.println("");
            log.log(Level.FINE, "Respond to client: Приветствую! Я знаю много умных фраз, спроси меня!");
            ask = in.nextLine();
            log.log(Level.FINE, "Client request:" + ask);
            while (!("пока".equalsIgnoreCase(ask))) {
                int random = (int) (Math.random() * 95);
                for (int index = 0; index < 5; index++) {
                    ask = answer.get((int) (random + index));
                    log.log(Level.FINE, "Respond to client:" + ask);
                    out.println(ask);
                }
                out.println("");
                ask = in.nextLine();
                log.log(Level.FINE, "Client request:" + ask);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.log(Level.WARNING, "Server ERROR", e);
        }
    }

    public static void main(String[] args) {
        try {
            Path answers = Paths.get("C:", "Java", "answers.txt");
            new Oracle().starServer(new ServerSocket(1987).accept(), answers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Logger log(Level mylevel) {
        Logger log = Logger.getLogger("ServerLog");
        log.setLevel(mylevel);
        log.setUseParentHandlers(false);
        final Handler registr = new ConsoleHandler();
        log.addHandler(registr);
        registr.setLevel(mylevel);
        return log;
    }

}
