/**
 * Package ru.job4j.crosszero for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Class OneGame - main loop for one game
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.02.2020
 */
public class OneGame {
    private static final Logger LOG = LogManager.getLogger(OneGame.class.getName());
    /**
     * constant with value for exit from menu
     */
    private final static String STOP = "exit";

    /**
     * link to game board
     */
    private Deck board;
    /**
     * start AI or not
     */
    private String aiUser;
    /**
     * size of board
     */
    private int size;
    /**
     * contains last answer of user
     */
    private String answer;
    /**
     * link to Logic object
     */
    private Logic log;
    /**
     * link to AI
     */
    private AIactions aiact;
    /**
     * contains recongized answer of user
     */
    private String[] action = {"--", "--", "--"};
    /**
     * ask and inform user
     */
    private Interact inter;
    /**
     * methods for understanding user answers
     */
    private IInterpretator interpret;

    /**
     * constructor for OneGame class
     *
     * @param inter class for sending messages
     * @param interpret class for recognition answers from user
     * @param prop properies for game
     */
    public OneGame(Interact inter, IInterpretator interpret, Properties prop) {
        this.aiUser = (String) prop.get("ai");
        this.size = Integer.parseInt((String) prop.get("size"));
        this.answer = "";
        this.board = new Deck(size);
        aiact = new ConsistentAI(board.getBoard());
        this.log = new Logic(board.getBoard());
        this.inter = inter;
        this.interpret = interpret;
    }

    /**
     * main loop of game
     *
     * @return "X" - winner is X gamer, "O" - winner is X gamer, "draw" - draw
     */
    String playGame() {
        board.cleanBoard();
        board.printBoard(inter);
        while (!answer.equalsIgnoreCase(STOP)) {
            answer = userTurn("X");
            if (answer.equals(STOP)) {
                return STOP;
            }
            if (winCheck("X")) {
                return answer;
            }
            if (!aiUser.equalsIgnoreCase("null")) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    LOG.error("Pause error", e);
                }
                inter.informUser("AI turn:\n");
                answer = aiact.aiturn();
                board.printBoard(inter);
            } else {
                answer = userTurn("O");
            }
            if (winCheck("O")) {
                return answer;
            }
            if (answer.equals(STOP)) {
                return STOP;
            }
            if (log.hasGap()) {
                inter.informUser("Threre is the draw, game started again\n");
                return "draw";
            }
        }
        return answer;
    }

    /**
     * execute actions for user turn
     *
     * @param symbol sybol of user
     * @return "X" or "exit" for nxt methods
     */
    private String userTurn(String symbol) {
        action[1] = "";
        int x = 0;
        int y = 0;
        while (!action[1].matches("[=/_\\-]")) {
            while (!answer.matches("^[1-9]+[=/_\\-][1-9]+$")) {
                answer = inter.askUser("User " + symbol + " - please make your turn, write coordinates by 1-1/1-2/3-3 \n"
                        + "or write \" exit \" to get to main menu\n");
                if (answer.equals(STOP)) {
                    return STOP;
                }
            }
            action = interpret.understand(answer);
            x = Integer.parseInt(action[0]) - 1;
            y = Integer.parseInt(action[2]) - 1;
            if (!log.chechCell(x, y)) {
                action[1] = "";
                inter.informUser("Cell isn't correct. ");
            }
        }
        board.setTurn(x, y, symbol);
        board.printBoard(inter);
        return symbol;
    }

    /**
     * start procedure to determine winner
     *
     * @param symbol symbol of user to check
     * @return tue - win, false - priceed game
     */
    private boolean winCheck(String symbol) {
        if (log.isWinner(symbol)) {
            inter.informUser("Last game has been winned the player " + symbol + "\n");
            return true;
        }
        return false;
    }

}

