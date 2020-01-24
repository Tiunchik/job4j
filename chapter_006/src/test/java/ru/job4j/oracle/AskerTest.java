/**
 * Пакет для работы с IO, создание сетевого бота
 *
 * @author Maksim Tiunchik
 */

package ru.job4j.oracle;

import com.google.common.base.Joiner;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Класс OracleTest - класс для автоматических тестов клиента сервера
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 25.01.2020
 */
public class AskerTest {

    private static final String SEP = System.getProperty("line.separator");

    @Before
    public void setUp() throws Exception {
        PrintStream myOut = System.out;

    }

    private void testServer(String questions, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream outArr = new ByteArrayOutputStream();
        ByteArrayInputStream inArr = new ByteArrayInputStream(questions.getBytes());
        when(socket.getOutputStream()).thenReturn(outArr);
        when(socket.getInputStream()).thenReturn(inArr);
        new Asker().client(socket, new Input() {
                    int index = -1;
                    String[] tempAnsers = {"1", "пока"};

                    @Override
                    public String answer() throws IOException {
                        index++;
                        return tempAnsers[index];
                    }
                }
        );
        assertEquals(expected, outArr.toString());
    }

    @Test
    public void whenWeOnlySayBy() throws IOException {
        String expected = Joiner.on(SEP).join(
                "answer",
                "answer\r\n",
                "answer", "answer", "answer\r\n", "", "answer", "answer", ""


        );
        String answer = Joiner.on(SEP).join(
                "1",
                "пока",
                ""

        );
        testServer(expected, answer);
    }

}