/**
 * Package ru.job4j.generator for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.generator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class TextGenerator - realization of interface SimpleGenerator, wrok with regex
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 02.03.2020
 */
public class TextGenerator implements SimpleGenerator {
    private static final Logger LOG = LogManager.getLogger(TextGenerator.class.getName());

    private final static Pattern KEYS = Pattern.compile("\\$\\{.+?}");

    /**
     * Take String text with patterns and make replacments accordings keys from Map
     *
     * @param template text with patterns
     * @param keys     key for replacments
     * @return text with replacmnets
     * @throws KeyException can throw exeption if there isn't required key
     */
    @Override
    public String terminate(String template, Map<String, String> keys) throws KeyException {
        Matcher matcher = KEYS.matcher(template);
        for (var t : keys.keySet()) {
            if (!template.contains("${" + t + "}")) {
                throw new KeyException("excess key");
            }
        }
        StringBuilder builder = new StringBuilder();
        while (matcher.find()) {
            int start = matcher.start(0);
            int end = matcher.end(0);
            String temp = template.substring(start, end);
            temp = temp.substring(2, temp.length() - 1);
            temp = keys.get(temp);
            if (temp == null) {
                throw new KeyException("missing key");
            }
            matcher.appendReplacement(builder, temp);
        }

        return builder.toString();
    }
}
