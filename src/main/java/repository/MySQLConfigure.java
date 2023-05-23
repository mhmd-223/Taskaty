package repository;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConfigure {
    private static class PropertiesWrapper {
        private static String password;
        private static String username;
        private static String url;
        private final String fileName = "application.properties";

        public PropertiesWrapper() {
            Properties properties = new Properties();

            try (InputStream input = new FileInputStream("mysql.properties")) {
                // Load the properties file
                properties.load(input);

                // Retrieve the MySQL connection properties
                url = properties.getProperty("mysql.url");
                username = properties.getProperty("mysql.username");
                password = properties.getProperty("mysql.password");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(PropertiesWrapper.url, PropertiesWrapper.username, PropertiesWrapper.password);//creating connection with mySQL
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


}
