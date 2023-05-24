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
        try {
            // creating connection with mySQL
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskaty","root", "Welcome@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public static void accessDatabase(Connection connection,String query){
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
        private static String password;
        private static String username;
        private static String url;

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
