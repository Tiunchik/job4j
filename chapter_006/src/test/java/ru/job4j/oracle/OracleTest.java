/**
 * Пакет для работы с IO, создание сетевого бота
 *
 * @author Maksim Tiunchik
 */

package ru.job4j.oracle;

import com.google.common.base.Joiner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.net.Socket;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Класс OracleTest - класс для автоматических тестов сервера
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 25.01.2020
 */
public class OracleTest {

    private Path tempFile;
    private List<String> tempList;
    private static final String SEP = System.getProperty("line.separator");

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Before
    public void setUp() throws Exception {
        tempList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            tempList.add("answer");
        }
        tempFile = tempFolder.newFile("answers.txt").toPath();
        try (BufferedWriter out = new BufferedWriter(new FileWriter(tempFile.toFile()))) {
            for (var e : tempList) {
                out.write(e);
                out.write("\n");
            }
        }
    }

    private void testServer(String questions, String expected) throws IOException {
        Socket server = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(questions.getBytes());
        when(server.getOutputStream()).thenReturn(out);
        when(server.getInputStream()).thenReturn(in);
        new Oracle().starServer(server, tempFile);
        assertEquals(expected, out.toString());
    }

    @Test
    public void whenWeOnlySayBy() throws IOException {
        String expected = Joiner.on(SEP).join(
                "пока",
                ""

        );
        String answer = Joiner.on(SEP).join(
                "Приветствую! Я знаю много умных фраз, спроси меня!",
                "",
                ""

        );
        testServer(expected, answer);
    }

    @Test
    public void whenWeAskOneQuestion() throws IOException {
        String expected = Joiner.on(SEP).join(
                "hi",
                "пока"

        );
        String answer = Joiner.on(SEP).join(
                "Приветствую! Я знаю много умных фраз, спроси меня!",
                "",
                "answer", "answer", "answer", "answer", "answer", "", ""
        );
        testServer(expected, answer);
    }
}