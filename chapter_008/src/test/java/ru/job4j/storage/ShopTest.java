package ru.job4j.storage;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class ShopTest {


    @Test
    public void test() throws ParseException {
        Storage<Food> warehouse = new Warehouse<>();
        Storage<Food> shop = new Shop<>();
        Storage<Food> trash = new Trash<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date creation = dateFormat.parse("15.05.2018");
        Date expairation = dateFormat.parse("25.05.2018");
        shop.push(new Apple("Apple", expairation, creation, 100, 0));
        creation = dateFormat.parse("12.02.2020");
        expairation = dateFormat.parse("25.05.2020");
        shop.push(new Bread("Bread", expairation, creation, 100, 0));
        new ControllQuality<Food>().sort(shop, warehouse, trash);
        assertEquals("Apple", trash.get().getName());
        assertEquals("Bread", shop.get().getName());

    }
}