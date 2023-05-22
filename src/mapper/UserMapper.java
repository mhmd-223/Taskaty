package mapper;

import entity.User;
import repository.JdbcConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserMapper implements UserMapperInterface {
    User user = new User();

    @Override
    public User getUser(String userName) {
        Connection connection = JdbcConfig.getConnection();
        String query = "Select * from User where UserName=" + userName;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                user.setUsername(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("Password"));
            }
            resultSet.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
