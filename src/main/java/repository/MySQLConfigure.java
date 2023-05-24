package repository;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConfigure {
    public static Connection getConnection() {
        Connection connection;
        PropertiesWrapper wrapper = new PropertiesWrapper();
        try {
            // creating connection with mySQL
            connection = DriverManager.getConnection(wrapper.url, wrapper.username, wrapper.password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void accessDatabase(Connection connection, String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static class PropertiesWrapper {
        private String password;
        private String username;
        private String url;

        public PropertiesWrapper() {
            Properties properties = new Properties();

            String fileName = "application.properties";
            try (InputStream input = new FileInputStream(fileName)) {
                /* Load the properties file */
                properties.load(input);
                /* Retrieve the MySQL connection properties */
                url = properties.getProperty("mysql.url");
                username = properties.getProperty("mysql.username");
                password = properties.getProperty("mysql.password");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
