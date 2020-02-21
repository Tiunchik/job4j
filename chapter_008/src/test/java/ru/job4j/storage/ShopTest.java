package ru.job4j.storage;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.*;

import static org.junit.Assert.*;

public class ShopTest {

    private Storage<Food> warehouse = new Warehouse<>();
    private Storage<Food> shop = new Shop<>();
    private Storage<Food> trash = new Trash<>();
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
        Map<Double, TakeAction<Food>> act = new HashMap<>(Map.of(
                0.25, new PutToWarehouse<Food>(warehouse),
                0.75, new PutToShop<Food>(shop),
                1.0, new PutToWarehouseWithDis<Food>(shop),
                99999.0, new PutToTrash<Food>(trash)
        ));
        tempList = quality.prepareList(new HashSet<>(Set.of(shop, warehouse)));
        quality.sort(act, tempList);
        assertEquals("Apple", trash.get().getName());
        assertEquals("Bread", warehouse.get().getName());

    }
}