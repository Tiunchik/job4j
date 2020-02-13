/**
 * Пакет ru.job4j.magnit для решения тестового здания магазина Магнит с использованем SQLlite
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.magnit;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс StoreSQLTest - класс для модульного тестирования проводимой работы
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.3
 * @since 13.02.2020
 */
public class StoreSQLTest {

    @Test
    public void fulltestofusualwork() {
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
        File entries = new File(System.getProperty("java.io.tmpdir") + "/entries.xsl");
        try (BufferedWriter writer = Files.newBufferedWriter(entries.toPath())) {
            String text = "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">"
                   + "    <xsl:template match=\"/\">"
                   + "        <entries>"
                   + "            <xsl:for-each select=\"entries/entry\">"
                   + "                <entry>"
                   + "                    <xsl:attribute name=\"href\">"
                   + "                        <xsl:value-of select=\"field\"/>"
                   + "                    </xsl:attribute>"
                   + "                </entry>"
                   + "            </xsl:for-each>"
                   + "        </entries>"
                   + "    </xsl:template>"
                   + "</xsl:stylesheet>";
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new StoreXML(new File(System.getProperty("java.io.tmpdir") + "/log.xml")).save(temp);
        new ConvertXSQT().convert(new File(System.getProperty("java.io.tmpdir") + "/log.xml"),
                new File(System.getProperty("java.io.tmpdir") + "/relog.xml"),
                entries);
        int answer = Parser.parserSAX(new File(System.getProperty("java.io.tmpdir") + "/relog.xml"));
        Assert.assertEquals(1784293664, answer);
    }
}