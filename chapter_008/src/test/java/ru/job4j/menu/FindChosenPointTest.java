package ru.job4j.menu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindChosenPointTest {

    public Node root;

    @Before
    public void setUP() {
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


    @Test
    public void whenWeTryFindDeepestPointThenCheckNames() {
        FindChosenPoint findPoint = FindChosenPoint.getFinder(root);

        Node actual = findPoint.find("1.3.1");

        String expected = "onethreeone";

        Assert.assertEquals(expected, actual.name);
    }

    @Test
    public void whenWeTryFindDeepestPointAndPressIncorectNumberThenGetIncorrectPoint() {
        FindChosenPoint findPoint = FindChosenPoint.getFinder(root);

        Node actual = findPoint.find("1.5.1");

        String expected = "onethreeone";

        Assert.assertNotEquals(expected, actual.name);
    }

    @Test(expected = NullPointerException.class)
    public void whenWeTryFindPointAndPressOnlyLettersThenGetNPE() {
        FindChosenPoint findPoint = FindChosenPoint.getFinder(root);

        Node actual = findPoint.find("null");

        String expected = "onethreeone";

        Assert.assertNotEquals(expected, actual.name);
    }
}