/**
 * Package ru.job4j.interfacegame for
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.interfacegame;

import java.util.Set;

/**
 * Interface Position - 
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 26.02.2020
 */
public interface Position {

    /**
     * return set of users located on this position
     *
     * @return return set of users located on this position
     */
    Set<User> getUser();

    /**
     * add user to set of user in this position
     *
     * @param user user for adding
     * @return true if user added, or false
     */
    boolean addUser(User user);

    /**
     * delete user from set of user in this position
     *
     * @param user user for deleting
     * @return true if user deleted, or false
     */
    boolean delUser(User user);

    /**
     * get information about position, it's used for defenitions list of events
     *
     * @return get information about position
     */
    String getStatus();
}
