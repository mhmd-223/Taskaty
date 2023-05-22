package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConfig {
    private static String url="";
    private static String username="";
    private static String password="";
    private static Connection connection;

    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(url,username,password);//creating connection with mySQL
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        JdbcConfig.url = url;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        JdbcConfig.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        JdbcConfig.password = password;
    }
}
