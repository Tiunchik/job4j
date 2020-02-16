/**
 * Пакет ru.job4j.sqlfinaltest для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.sqlfinaltest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс SQLMainClass -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since -
 */
public class SQLMainClass {
    private static final Logger LOG = LogManager.getLogger(SQLMainClass.class.getName());

    private Connection connect;

    public void setupConnect(String propName) {
        Config prop = new Config();
        prop.init(propName);
        try {
            Class.forName(prop.get("driver-class-name"));
            connect = DriverManager.getConnection(prop.get("url"),
                    prop.get("username"),
                    prop.get("password")
            );
        } catch (Exception ex) {
            LOG.error("setupConnection mistake", ex);
        }
    }

    public void createDB() {
        try (Statement st = connect.createStatement()) {
            st.execute("SELECT 'CREATE DATABASE meetings'"
                    + " WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'meetings')");
        } catch (SQLException e) {
            LOG.error("create db error", e);
        }
    }

    public void createTables() {
        try (Statement st = connect.createStatement()) {
            st.addBatch("CREATE TABLE IF NOT EXISTS meetings ("
                    + " id serial primary key,"
                    + " names varchar(200)"
                    + ")");
            st.addBatch("CREATE TABLE IF NOT EXISTS users ("
                    + " id serial primary key,"
                    + " names varchar(200)"
                    + ")");
            st.addBatch("CREATE TABLE IF NOT EXISTS attends ("
                    + " id serial primary key,"
                    + " meeting_id integer not null references meetings(id),"
                    + " users_id integer not null references users(id)"
                    + ")"
            );
            st.addBatch("CREATE TABLE IF NOT EXISTS status ("
                    + " attends_id integer references attends(id),"
                    + " status varchar(30) check ("
                    + " status = 'accept' or"
                    + " status = 'denied' or"
                    + " status = 'notrespond')"
                    + " )"
            );
            st.executeBatch();
        } catch (SQLException e) {
            LOG.error("create table error", e);
        }
    }

    public void dropAll() {
        try (Statement st = connect.createStatement()) {
            st.addBatch("drop TABLE IF EXISTS meetings CASCADE");
            st.addBatch("drop TABLE IF EXISTS users CASCADE");
            st.addBatch("drop TABLE IF EXISTS attends CASCADE");
            st.addBatch("drop TABLE IF EXISTS status CASCADE");
            st.executeBatch();
        } catch (SQLException e) {
            LOG.error("drop table error", e);
        }
    }

    public void inserttUser(String name) {
        try (PreparedStatement st = connect.prepareStatement("insert into users (names) values (?)")) {
            st.setString(1, name);
            st.execute();
        } catch (SQLException e) {
            LOG.error("insert user table error", e);
        }
    }

    public void insertMeeting(String name) {
        try (PreparedStatement st = connect.prepareStatement("insert into meetings (names) values (?)")) {
            st.setString(1, name);
            st.execute();
        } catch (SQLException e) {
            LOG.error("insert meeting table error", e);
        }
    }

    public void createAttends(String username, String meetingname) {
        try (PreparedStatement st = connect.prepareStatement("insert into attends (users_id, meeting_id) "
                + "values ((select id from users where users.names =?), "
                + "(select id from meetings where meetings.names =?) )")) {
            st.setString(1, username);
            st.setString(2, meetingname);
            st.execute();
        } catch (SQLException e) {
            LOG.error("create attends table error", e);
        }
    }

    public void attendStatus(String username, String meetingname, String status) {
        try (PreparedStatement st = connect.prepareStatement("insert into status (attends_id, status) values "
                + "((select id from attends where users_id=(select id from users where users.names =?) and "
                + "meeting_id =(select id from meetings where meetings.names =?) ),?)")) {
            st.setString(1, username);
            st.setString(2, meetingname);
            st.setString(3, status);
            st.execute();
        } catch (SQLException e) {
            LOG.error("change attend status table error", e);
        }
    }

    public List<String> showMeetingStatus() {
        List<String> temp = new ArrayList<>();
        try (Statement st = connect.createStatement()) {
            try (ResultSet rsl = st.executeQuery("with tbs as (select meetings.names as names, count(status.status) as accepted  "
                    + "from meetings left outer join attends on meetings.id = attends.meeting_id "
                    + "right outer join status on status.attends_id = attends.id where status.status = 'accept' "
                    + "group by meetings.names) "
                    + "select meetings.names, tbs.accepted from meetings left outer join tbs on meetings.names = tbs.names;")) {
                temp.add(String.format("%20s %20s", "names", "accepted"));
                while (rsl.next()) {
                    temp.add(String.format("%20s %20s", rsl.getString("names"), rsl.getString("accepted")));
                }
            }
        } catch (SQLException e) {
            LOG.error("showMeetingStatus table error", e);
        }
        return temp;
    }

    public List<String> showEmptyMeetings() {
        List<String> temp = new ArrayList<>();
        try (Statement st = connect.createStatement()) {
            try (ResultSet rsl = st.executeQuery("select meetings.names, count(attends.meeting_id) "
                    + "from meetings left outer join attends on meetings.id = attends.meeting_id "
                    + "group by meetings.names having count(attends.meeting_id) = 0;")) {
                temp.add(String.format("%20s", "names"));
                while (rsl.next()) {
                    temp.add(String.format("%20s", rsl.getString("names")));
                }
            }
        } catch (SQLException e) {
            LOG.error("showEmptyMeetings table error", e);
        }
        return temp;
    }

    public Connection getConnect() {
        return connect;
    }
}
