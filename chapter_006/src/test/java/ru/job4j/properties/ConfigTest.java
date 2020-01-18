package ru.job4j.properties;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ConfigTest {
    private List<String> temp;
    private File where;

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Before
    public void setUp() throws Exception {
        where = tempFolder.newFile("test");
        temp = new ArrayList<>(List.of(
                "\n",
                "## PostgreSQL",
                "\n",
                "hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect",
                "hibernate.connection.url=jdbc:postgresql://127.0.0.1:5432/trackstudio",
                "hibernate.connection.driver_class=org.postgresql.Driver",
                "hibernate.connection.username=postgres",
                "hibernate.connection.password=password"
        ));
        try (BufferedWriter out =
                     new BufferedWriter(new OutputStreamWriter(
                             new FileOutputStream(where)))) {
            for (String s : temp) {
                out.write(s);
                out.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something go incorrectly");
        }
    }

    @Test
    public void whenTestActualLoad() {
        Config config = new Config(where.toString());
        config.load();
        assertEquals("postgres", config.value("hibernate.connection.username"));
    }
}

