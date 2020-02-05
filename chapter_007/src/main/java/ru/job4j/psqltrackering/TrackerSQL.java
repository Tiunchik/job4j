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

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Класс TrackerSQL - реализация трекера с базой данной в виде SQL сервера.
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since -
 */
public class TrackerSQL implements ITracker, AutoCloseable {
    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class.getName());

    private Connection connection;
    private boolean baseOn = false;
    private boolean connectionOn = false;

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
        if (!connectionOn) {
            init();
        }
        try {
            Statement st = connection.createStatement();
            st.execute("drop table if exists items");
            st.execute("create table items ("
                    + "id serial primary key,"
                    + "item_name varchar(100))");
        } catch (SQLException r) {
            LOG.error("Table creating error", r);
        }
        baseOn = true;
    }


    @Override
    public Item add(Item item) {
        if (!baseOn) {
            table();
        }
        try {
            PreparedStatement st = connection.prepareStatement("insert into items (item_name) values (?)");
            st.setString(1, item.getName());
            st.execute();
        } catch (SQLException r) {
            LOG.error("Item adding error", r);
        }
        return null;
    }

    @Override
    public boolean replace(String id, Item item) {
        if (!baseOn) {
            table();
        }
        try {
            PreparedStatement st = connection.prepareStatement("update items set item_name = ? where id = ?");
            st.setString(1, item.getName());
            int temp = Integer.parseInt(id);
            st.setInt(2, temp);
            st.execute();
        } catch (SQLException r) {
            LOG.error("Replace item error", r);
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        if (!baseOn) {
            table();
        }
        try {
            PreparedStatement st = connection.prepareStatement("delete from items where id = ?");
            int temp = Integer.parseInt(id);
            st.setInt(1, temp);
            st.execute();
        } catch (SQLException r) {
            LOG.error("Delete item error", r);
        }
        return true;
    }

    @Override
    public Item[] findAll() {
        List<Item> temp = new ArrayList<>();
        if (!baseOn) {
            table();
        }
        try {
            Statement st = connection.createStatement();
            ResultSet anwer = st.executeQuery("select * from items");
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
        if (!baseOn) {
            table();
        }
        try {
            PreparedStatement st = connection.prepareStatement("select * from items where item_name =?");
            st.setString(1, key);
            ResultSet anwer = st.executeQuery();
            while (anwer.next()) {
                Item tempItem = new Item(anwer.getString("item_name"));
                tempItem.setId(anwer.getString("id"));
                temp.add(tempItem);
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
        if (!baseOn) {
            table();
        }
        try {
            PreparedStatement st = connection.prepareStatement("select * from items where id =?");
            int temp = Integer.parseInt(id);
            st.setInt(1, temp);
            ResultSet anwer = st.executeQuery();
            while (anwer.next()) {
                tempItem = new Item(anwer.getString("item_name"));
                tempItem.setId(anwer.getString("id"));
                return tempItem;
            }
        } catch (SQLException r) {
            LOG.error("findByName item error", r);
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
