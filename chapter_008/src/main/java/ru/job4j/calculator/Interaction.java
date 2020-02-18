/**
 * Calculator package.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

/**
 * Класс Interaction - contains methods for asking and respons to user.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 17.02.2020
 */
public class Interaction {
    /**
     * inner logger.
     */
    private static final Logger LOG = LogManager.getLogger(Interaction.class.getName());

    /**
     * constand for console reader.
     */
    private BufferedReader reader;

    /**
     * replacemnet of default constructor, initializes constant reader.
     */
    public Interaction() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * print text to console.
     *
     * @param inform prined text
     */
    public void informUser(String inform) {
        System.out.println(inform);
    }

    /**
     * print text to consolu and get answer from user.
     *
     * @param question prined text
     * @return user redpond
     */
    public String askUser(String question) {
        try {
            System.out.println(question);
            return reader.readLine();
        } catch (IOException ioe) {
            LOG.error("askUser error", ioe);
        }
        return "0";
    }
}
