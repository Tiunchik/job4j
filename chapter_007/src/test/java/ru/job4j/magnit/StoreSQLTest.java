/**
 * Пакет ru.job4j.magnit для решения тестового здания магазина Магнит с использованем SQLlite
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.magnit;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс StoreSQLTest - класс для ручной тестировки проводимой работы
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.02.2020
 */
public class StoreSQLTest {

    @Ignore
    public void firstTest() {
        List<Entry> temp = new LinkedList<>();
        Config config = new Config();
        config.init();
        Assert.assertEquals("postgres", config.get("username"));
        StoreSQL store = new StoreSQL(config);
        try {
            store.getConnect().setAutoCommit(false);
            store.generate(1000000);
            temp = store.load();
            Assert.assertEquals(1000000, temp.size());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                store.getConnect().rollback();
                store.getConnect().setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        new StoreXML(new File("c:/java/log.xml")).save(temp);
        new ConvertXSQT().convert(new File("c:/java/log.xml"),
                new File("c:/java/relog.xml"),
                new File("C:\\projects\\job4j\\chapter_007\\src\\main\\resources\\entries.xsl"));
        Parser.parserSAX(new File("c:/java/relog.xml"));
    }
}