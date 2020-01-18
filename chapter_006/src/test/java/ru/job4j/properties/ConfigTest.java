package ru.job4j.properties;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenTestActualLoad() {
        String path = "src\\main\\java\\ru\\job4j\\properties\\test.txt";
        Config config = new Config(path);
        config.load();
        assertEquals("postgres", config.value("hibernate.connection.username"));
    }
}

