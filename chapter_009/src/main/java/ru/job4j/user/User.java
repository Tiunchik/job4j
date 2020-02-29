/**
 * Package ru.job4j.user for work with GC
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class User - class for calling GC
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 29.02.2020
 */
public class User {
    private static final Logger LOG = LogManager.getLogger(User.class.getName());
    /**
     * namr of object
     */
    private String name;
    /**
     * special array to make object heavier
     */
    private char[] eatSpace;

    /**
     * constructor
     *
     * @param name set name
     * @param array set size of array
     */
    public User(String name, int array) {
        this.name = name;
        eatSpace = new char[array];
    }

    /**
     * when object is cleared by GC, sout name of object
     *
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(String.format("Deleted object: %10s", name));
    }

    /**
     * print information about memoty size
     */
    public void info() {
        int kb = 1024;
        Runtime run = Runtime.getRuntime();
        System.out.println("Free memory: " + run.freeMemory() / kb);
        System.out.println("All memory: " + run.totalMemory() / kb);
    }

    /**
     * main - manual test, -xmx20m
     *
     * @param args
     */
    public static void main(String[] args) {
        User user = new User("testName", 100);
        user.info();
        int index = 0;
        while (index < 50000) {
            index++;
            user = new User("testName" + index, 100);
        }
    }
}
