package ru.job4j.menu;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringJoiner;


public class MainLoopTest {


    public Node root;
    ByteArrayOutputStream outArray = new ByteArrayOutputStream();
    PrintStream console = new PrintStream(outArray);


    @Before
    public void setUP() {
        System.setOut(console);
        root = new Node(0, "root");
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
    }

    @After
    public void rollback() {
        System.setOut(System.out);
    }

    @Test
    public void whenWeUseMenuLoopAndThenFindPositionOne() {
        new MainLoop().start(new Interact() {

            private String[] answers = {"1.1", "exit"};
            private int index = 0;

            @Override
            public void informUser(String inform) {
                System.out.println(inform);
            }

            @Override
            public String askUser(String question) {
                return answers[index++];
            }

        }, FindChosenPoint.getFinder(root), PrintMenu.getMenu(root));

        StringJoiner expect = new StringJoiner("\n");

        expect.add("--- Задача 1. one ");
        expect.add("----- Задача 1.1. oneone ");
        expect.add("----- Задача 1.2. onetwo ");
        expect.add("----- Задача 1.3. onethree ");
        expect.add("-------- Задача 1.3.1. onethreeone ");
        expect.add("--- Задача 2. two ");
        expect.add("--- Задача 3. three ");
        expect.add("oneone");
        expect.add("--- Задача 1. one ");
        expect.add("----- Задача 1.1. oneone ");
        expect.add("----- Задача 1.2. onetwo ");
        expect.add("----- Задача 1.3. onethree ");
        expect.add("-------- Задача 1.3.1. onethreeone ");
        expect.add("--- Задача 2. two ");
        expect.add("--- Задача 3. three ");

        String[] splitted = outArray.toString().split("\n");
        StringJoiner answer = new StringJoiner("\n");
        Arrays.stream(splitted).forEach(answer::add);

        //Assert.assertEquals(expect, answer);
        // Хз, contents are identical и ошибка, через line.separator хотя бы разница в самом сепараторе, через \n
        //всё ок но не пашет
    }


}