/**
 * Пакет ru.job4j.pSQLtracker для работы с psql
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.psqltrackering;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.oop.tracker.ITracker;
import ru.job4j.oop.tracker.Item;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * Класс TrackerSQL - реализация трекера с базой данной в виде SQL сервера.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.2
 * @since 08.02.2020
 */
public class TrackerSQL implements ITracker, AutoCloseable {
    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class.getName());

    private Connection connection;

    public TrackerSQL() {
        init();
        table();
    }

    public TrackerSQL(Connection connection) {
        this.connection = connection;
        table();
    }

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            Statement st = connection.createStatement();
            st.execute("drop database if exists tracker");
            st.execute("create database tracker");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    private void table() {
        try {
            Statement st = connection.createStatement();
            st.execute("drop table if exists items");
            st.execute("create table items ("
                    + "id varchar(80) primary key,"
                    + "item_name varchar(100))");
        } catch (SQLException r) {
            LOG.error("Table creating error", r);
        }
    }


    @Override
    public Item add(Item item) {
        String temp = "";
        try (PreparedStatement st = connection
                .prepareStatement("insert into items (id, item_name) values (?, ?)")) {
            temp = generateId();
            st.setString(1, temp);
            st.setString(2, item.getName());
            st.execute();
        } catch (SQLException r) {
            LOG.error("Item adding error", r);
        }
        Item tempItemp = new Item(item.getName());
        tempItemp.setId(temp);
        return tempItemp;
    }

    @Override
    public boolean replace(String id, Item item) {
        var answer = false;
        try (PreparedStatement st = connection
                .prepareStatement("update items set item_name = ? where id = ?")) {
            st.setString(1, item.getName());
            st.setString(2, id);
            st.execute();
        } catch (SQLException r) {
            LOG.error("Replace item error", r);
        }
        return answer;
    }

    @Override
    public boolean delete(String id) {
        var answer = false;
        try (PreparedStatement st = connection.prepareStatement("delete from items where id = ?")) {
            st.setString(1, id);
            answer = st.execute();
        } catch (SQLException r) {
            LOG.error("Delete item error", r);
        }
        return answer;
    }

    @Override
    public Item[] findAll() {
        List<Item> temp = new ArrayList<>();
        try (Statement st = connection.createStatement();
             ResultSet anwer = st.executeQuery("select * from items")) {
            while (anwer.next()) {
                Item tempItem = new Item(anwer.getString("item_name"));
                tempItem.setId(anwer.getString("id"));
                temp.add(tempItem);
            }
        } catch (SQLException r) {
            LOG.error("FindAll item error", r);
        }
        Item[] tempArray = new Item[temp.size()];
        temp.toArray(tempArray);
        return tempArray;

    }

    @Override
    public Item[] findByName(String key) {
        List<Item> temp = new ArrayList<>();
        try (PreparedStatement st = connection
                .prepareStatement("select * from items where item_name =?")) {
            st.setString(1, key);
            try (ResultSet anwer = st.executeQuery()) {
                while (anwer.next()) {
                    Item tempItem = new Item(anwer.getString("item_name"));
                    tempItem.setId(anwer.getString("id"));
                    temp.add(tempItem);
                }
            }
        } catch (SQLException r) {
            LOG.error("findByName item error", r);
        }

        Item[] tempArray = new Item[temp.size()];
        temp.toArray(tempArray);
        return tempArray;
    }

    @Override
    public Item findById(String id) {
        Item tempItem;
        try (PreparedStatement st = connection.prepareStatement("select * from items where id =?")) {
            st.setString(1, id);
            try (ResultSet anwer = st.executeQuery()) {
                while (anwer.next()) {
                    tempItem = new Item(anwer.getString("item_name"));
                    tempItem.setId(anwer.getString("id"));
                    return tempItem;
                }
            }
        } catch (SQLException r) {
            LOG.error("FindByName item error", r);
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    private String generateId() {
        Random korea = new Random();
        return String.valueOf(System.currentTimeMillis() + korea.nextLong());
    }
}
