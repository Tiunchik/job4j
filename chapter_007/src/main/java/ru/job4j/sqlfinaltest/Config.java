/**
 * Пакет ru.job4j.magnit для решения тестового здания магазина Магнит с использованем SQLlite
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.sqlfinaltest;

import java.io.InputStream;
import java.util.Properties;

/**
 * Класс Config - для полчения класс свойств
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.02.2020
 */
public class Config {
    private final Properties values = new Properties();

    public void init(String propName) {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream(propName)) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}

