/**
 * Calculator package.
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.calculator.anothercalculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Класс Interpritator -main class interpritator string to strng[].
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since v
 */
public class Interpritator {
    /**
     * inner logger
     */
    private static final Logger LOG = LogManager.getLogger(Interpritator.class.getName());

    /**
     * takes string expression and convert to string massive with parameters.
     *
     * @param answer String answer from user.
     * @return String[] 0 - first number, 1 - arithmetic action, 2 - second number.
     */
    public String[] understand(String answer) {
        String[] tempString = {"", "", ""};
        char[] tempChar = answer.toCharArray();
        var middle = false;
        if (answer.matches("^[0-9]+.*[0-9]+$|^.*[0-9]+$")) {
            for (var e : tempChar) {
                String letter = "" + e;
                if (!letter.matches("[0-9]")) {
                    middle = true;
                    tempString[1] = tempString[1] + letter;
                }
                if (letter.matches("[0-9]") && !middle) {
                    tempString[0] = tempString[0] + letter;
                }
                if (letter.matches("[0-9]") && middle) {
                    tempString[2] = tempString[2] + letter;
                }

            }
        } else {
            return null;
        }
        return tempString;
    }
}
