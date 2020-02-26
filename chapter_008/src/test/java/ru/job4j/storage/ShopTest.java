package ru.job4j.storage;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.*;

import static org.junit.Assert.*;

public class ShopTest {

    private Storage warehouse = new Warehouse();
    private Storage shop = new Shop();
    private Storage trash = new Trash();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private Date creation;
    private Date expairation;


    @Before
    public void beforeActions() throws ParseException {
        creation = dateFormat.parse("15.05.2018");
        expairation = dateFormat.parse("25.05.2018");
        shop.push(new Apple("Apple", expairation, creation, 100, 0));
        creation = dateFormat.parse("12.02.2020");
        expairation = dateFormat.parse("25.05.2020");
        shop.push(new Bread("Bread", expairation, creation, 100, 0));
    }

    @Test
    public void test() throws ParseException {
        Set<Storage> act = new HashSet<Storage>(Set.of(warehouse, shop, trash));
        ControllQuality quality = new ControllQuality(act);
        List<Food> tempList = new ArrayList<>();
        tempList = quality.prepareList();
        quality.addAll(tempList);
        quality.resort();
        assertEquals("Apple", trash.get().getName());
        assertEquals("Bread", warehouse.get().getName());

    }
}