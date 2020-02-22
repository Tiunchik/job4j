package ru.job4j.menu;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintMenuTest {

    ByteArrayOutputStream outArray = new ByteArrayOutputStream();
    PrintStream myOut = new PrintStream(outArray);

    @Before
    public void before() {
        System.setOut(myOut);
    }

    @After
    public void after() {
        System.setOut(System.out);
    }


    @Test
    public void testPrintMenu() {
        Node root = new Node(0, "root");
        Node one = new Node(1, "one");
        Node two = new Node(2, "two");
        Node three = new Node(3, "three");
        root.leafs.add(one);
        root.leafs.add(two);
        root.leafs.add(three);
        Node oneone = new Node(1, "oneone");
        Node onetwo = new Node(2, "onetwo");
        Node onethree = new Node(3, "onethree");
        one.leafs.add(oneone);
        one.leafs.add(onetwo);
        one.leafs.add(onethree);
        Node onethreeone = new Node(1, "onethreeone");
        onethree.leafs.add(onethreeone);
        PrintMenu menu = PrintMenu.getMenu(root);
        menu.print();
        String expected = "--- Задача 1. one \n"
                + "----- Задача 1.1. oneone \n"
                + "----- Задача 1.2. onetwo \n"
                + "----- Задача 1.3. onethree \n"
                + "-------- Задача 1.3.1. onethreeone \n"
                + "--- Задача 2. two \n"
                + "--- Задача 3. three \n";
        Assert.assertEquals(expected, outArray.toString());
    }

}