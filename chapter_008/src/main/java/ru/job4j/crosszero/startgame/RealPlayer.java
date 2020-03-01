/**
 * Package ru.job4j.crosszero.players for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.crosszero.startgame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.crosszero.interfaces.Interact;
import ru.job4j.crosszero.interfaces.InterfacePlayer;

/**
 * Class RealPlayer -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 01.03.2020
 */
public class RealPlayer implements InterfacePlayer {
    private static final Logger LOG = LogManager.getLogger(RealPlayer.class.getName());

    /**
     * contains onject with methods for interaction with user.
     */
    private Interact inter;

    /**
     * constructor of player.
     *
     * @param inter object for interaction with user
     */
    public RealPlayer(Interact inter) {
        this.inter = inter;
    }

    /**
     * player make turn.
     *
     * @param symbol symbol of player
     * @return sttment like 1-1 or othres, that point on position on board
     */
    @Override
    public String makeTurn(String symbol) {
        return inter.askUser(String.format("Player %s, please, make your turn\n", symbol));
    }
}
