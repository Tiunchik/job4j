/**
 * Тесты на методы класса-декоратора ValidateInput
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.oop.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Класс ValidateInputTest - набор автоматических тестов для методов класса ValidateInput
 *
 * @author -
 * @version 0.3
 */
public class ValidateInputTest {
    /**
     * Переменная записывает в себя ссылку на объект выполняющий функции вывода данных в консоль
     */
    private final PrintStream normalout = System.out;
    /**
     * Переменная записывает в себя ссылку на буфер, где может храниться выводимая в консоль информация
     */
    private final ByteArrayOutputStream testout = new ByteArrayOutputStream();

    /**
     * В данном методе вывод в консоль заменяется выводом в созданный ранее буфер.
     */
    @Before
    public void readFromBuffer() {
        System.setOut(new PrintStream(testout));
    }

    /**
     * в данном методе возвращаеться вывод в консоль
     */
    @After
    public void readFromConsole() {
        System.setOut(normalout);
    }

    /**
     * Тест работы исключений на методе askInt - введно значение типа String (не преобразуемое)
     */
    @Test
    public void whenStringInstead (){
        StubInput input = new StubInput(new String[]{"help", "0"});
        ValidateInput testinput = new ValidateInput(input);
        testinput.askInt("Select: ",6);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Please enter validate data again ")
                .toString();
        assertThat(testout.toString(),is(expect));
    }

    /**
     * Тест работы исключений на методе askInt - введно значение типа int больше значения max
     */
    @Test
    public void whenIntTooBig (){
        StubInput input = new StubInput(new String[]{"8", "2"});
        ValidateInput testinput = new ValidateInput(input);
        testinput.askInt("Select: ",4);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Please select key from menu ")
                .toString();
        assertThat(testout.toString(),is(expect));
    }
}
