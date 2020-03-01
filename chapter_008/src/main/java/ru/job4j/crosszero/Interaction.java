/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.crosszero.interfaces.Interact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class Interaction - contains methods for asking and respons to user.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 25.02.2020
 */
public class Interaction implements Interact {
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
        System.out.print(inform);
    }

    /**
     * print text to consol and get answer from user.
     *
     * @param question prined text
     * @return user redpond
     */
    public String askUser(String question) {
        try {
            System.out.print(question);
            return reader.readLine();
        } catch (IOException ioe) {
            LOG.error("askUser error", ioe);
        }
        return "0";
    }
}
