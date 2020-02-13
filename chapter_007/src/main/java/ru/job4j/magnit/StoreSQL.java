/**
 * Пакет ru.job4j.magnit для решения тестового здания магазина Магнит с использованем SQLlite
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.magnit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс StoreSQL -класс для создания и работы с SQLLite
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.3
 * @since 13.02.2020
 */


public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;

    public StoreSQL(Config config) {
        if (config != null) {
            try {
                connect = DriverManager.getConnection(config.get(System.getProperty("java.io.tmpdir") + "url"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        this.config = config;
    }

    public void generate(int size) {
        try (PreparedStatement pst = connect
                .prepareStatement("create table if not exists entry (field integer)")) {
            pst.execute();
        } catch (SQLException r) {
            r.printStackTrace();
        }
        try (PreparedStatement pst = connect.prepareStatement("insert into entry values (?)")) {
            if (connect != null) {
                for (int index = 1; index <= size; index = index + 5) {
                    pst.setInt(1, index);
                    pst.addBatch();
                    pst.setInt(1, index + 1);
                    pst.addBatch();
                    pst.setInt(1, index + 2);
                    pst.addBatch();
                    pst.setInt(1, index + 3);
                    pst.addBatch();
                    pst.setInt(1, index + 4);
                    pst.addBatch();
                    pst.executeBatch();
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
