package ru.job4j.sqlfinaltest;

import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class SQLMainClassTest {

    @Test
    public void testFirstQuery() {
        SQLMainClass main = new SQLMainClass();
        main.setupConnect("app.properties");
        main.dropAll();
        try {
            main.getConnect().setAutoCommit(false);
            main.createDB();
            main.createTables();
            main.inserttUser("Alex");
            main.inserttUser("Adam");
            main.insertMeeting("First meeting");
            main.insertMeeting("Second meeting");
            main.createAttends("Alex", "First meeting");
            main.attendStatus("Alex", "First meeting", "accept");
            List<String> temp = main.showEmptyMeetings();
            assertEquals(2, temp.size());
            temp = main.showMeetingStatus();
            String answer = String.format("%20s %20s", "First meeting", "1");
            assertTrue(temp.indexOf(answer) != -1);
            answer = String.format("%20s %20s", "Second meeting", "null");
            assertTrue(temp.indexOf(answer) != -1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}