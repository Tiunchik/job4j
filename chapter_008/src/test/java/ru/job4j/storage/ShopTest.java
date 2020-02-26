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
        ControllQuality<Food> quality = new ControllQuality();
        List<Food> tempList = new ArrayList<>();
        Map<Double, TakeAction> act = new HashMap<>(Map.of(
                0.25, new PutToWarehouse(warehouse),
                0.75, new PutToShop(shop),
                1.0, new PutToWarehouseWithDis(shop),
                99999.0, new PutToTrash(trash)
        ));
        tempList = quality.prepareList(new HashSet<>(Set.of(shop, warehouse)));
        quality.sort(act, tempList);
        assertEquals("Apple", trash.get().getName());
        assertEquals("Bread", warehouse.get().getName());

    }
}