/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Class Logic - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public class Logic {
    private static final Logger LOG = LogManager.getLogger(Logic.class.getName());

    private final String empty = "____";

    private String[][] table;

    public Logic(String[][] table) {
        this.table = table;
    }

    public boolean chechCell(int x, int y) {
        return x < table.length && y < table[x].length && table[x][y].equalsIgnoreCase(empty);
    }

    public boolean fillBy(String symbol, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            var cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!cell.equalsIgnoreCase(symbol)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinner(String symbol) {
        var rsl = false;

        for (int index = 0; index < table.length && !rsl; index++) {
            rsl = this.fillBy(symbol, 0, index, 1, 0);
        }

        for (int index = 0; index < table.length && !rsl; index++) {
            rsl = this.fillBy(symbol, index, 0, 0, 1);
        }

        if (!rsl) {
            rsl = this.fillBy(symbol, 0, 0, 1, 1);
        }
        if (!rsl) {
            rsl = this.fillBy(symbol, this.table.length - 1, 0, -1, 1);
        }
        return rsl;
    }


    public boolean hasGap() {
        return Stream.of(table).flatMap(Arrays::stream).noneMatch(e -> e.equalsIgnoreCase(empty));
    }

}
