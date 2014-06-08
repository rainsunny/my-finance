package net.jay.accounting.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by wangjie on 6/8/14 8:37 PM.
 */
public class DatabaseUtil {

    public static Connection getConnection() throws IOException, SQLException {

        Properties props = new Properties();

        FileInputStream in = new FileInputStream("/jdbc.properties");
        props.load(in);
        in.close();

        String drivers = props.getProperty("jdbc.drivers");
        if (drivers != null) System.setProperty("jdbc.drivers", drivers);
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, username, password);
    }
}
