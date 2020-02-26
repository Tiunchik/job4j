package ru.job4j.generator;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SimpleGeneratorTest {

    @Test
    public void wheWeHaveOneKeyThenPrintResukt() throws KeyException {
        SimpleGenerator gener = new TextGenerator();

        String text = "Mother is washing ${window}";
        Map<String, String> keys = new HashMap<>(Map.of("window", "Linux"));

        String answer = gener.terminate(text, keys);
        String expected = "Mother is washing Linux";

        assertEquals(expected, answer);
    }

    @Test
    public void wheWeHaveMoreThenOneKeyThenPrintResult() throws KeyException {
        SimpleGenerator gener = new TextGenerator();

        String text = "Luck I am your father! ${cry}, ${cry}, ${cry} ";
        Map<String, String> keys = new HashMap<>(Map.of("cry", "Nooo"));

        String answer = gener.terminate(text, keys);
        String expected = "Luck I am your father! Nooo, Nooo, Nooo ";

        assertEquals(expected, answer);
    }

    @Test(expected = KeyException.class)
    public void wheWeDontHaveKeyThenExpectExeption() throws KeyException {
        SimpleGenerator gener = new TextGenerator();
        String text = "Mother is washing ${window}";
        Map<String, String> keys = new HashMap<>(Map.of("windowleaf", "Linux"));

        gener.terminate(text, keys);
    }

    @Test(expected = KeyException.class)
    public void wheWeWeHaveExcessKeyThenKeyExotionExpected() throws KeyException {
        SimpleGenerator gener = new TextGenerator();
        String text = "Mother is washing ${window}";
        Map<String, String> keys = new HashMap<>(Map.of("windowleaf", "Linux", "excess", "excess"));

        gener.terminate(text, keys);
    }
}