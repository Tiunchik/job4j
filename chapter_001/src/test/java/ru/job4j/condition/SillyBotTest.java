package ru.job4j.condition;

import org.junit.Test;
import java.io.IOException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SillyBotTest {
        //если делать через case то во все тесты надо добавлять throws IOException ¯\_(ツ)_/¯
        @Test
        public void whenGreetBot() {
            assertThat(
                    SillyBot.answer("Привет, Бот."),
                    is("Привет, умник.")
            );
        }

        @Test
        public void whenByeBot() {
            assertThat(
                    SillyBot.answer("Пока."),
                    is("До скорой встречи.")
            );
        }

        @Test
        public void whenUnknownBot() {
            assertThat(
                    SillyBot.answer("Сколько будет 2 + 2?"),
                    is("Это ставит меня в тупик. Задайте другой вопрос.")
            );
        }
    }

