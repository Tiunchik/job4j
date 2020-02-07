/**
 * Пакет ru.job4j.magnit для решения тестового здания магазина Магнит с использованем SQLlite
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.magnit;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс StoreSQL -класс для создания и работы с SQLLite
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.02.2020
 */


public class StoreSQL implements AutoCloseable {
    private boolean baseOn = false;
    private final Config config;
    private Connection connect;

    public StoreSQL(Config config) {
        if (Files.exists(Paths.get(config.get("filepath")))) {
            baseOn = true;
        }
        if (config != null) {
            try {
                connect = DriverManager.getConnection(config.get("url"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        this.config = config;
    }

    public void generate(int size) {
        try {
            if (!baseOn) {
                PreparedStatement pst = connect.prepareStatement("create table entry (field integer)");
                pst.execute();
            }
            PreparedStatement pst = connect.prepareStatement("insert into entry values (?)");
            if (connect != null) {
                for (int index = 1; index <= size; index++) {
                    pst.setInt(1, index);
                    pst.execute();
                }
            }
        } catch (SQLException r) {
            r.printStackTrace();
        }
    }

    public List<Entry> load() {
        List<Entry> tempList = new ArrayList<>();
        try (PreparedStatement pr = connect.prepareStatement("select * from entry");
             ResultSet rs = pr.executeQuery()) {
            while (rs.next()) {
                tempList.add(new Entry(rs.getInt("field")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempList;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }

    public Config getConfig() {
        return config;
    }

    public Connection getConnect() {
        return connect;
    }

}
