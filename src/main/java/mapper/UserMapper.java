package mapper;

import entity.User;
import repository.MySQLConfigure;
import utilities.QueryBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserMapper implements UserMapperInterface {
    User user = new User();
    @Override
    public User getUser(String query,Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
            }
            resultSet.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
