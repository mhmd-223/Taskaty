package repository.mysql;

import entity.Task;
import entity.TaskList;
import entity.User;
import mapper.TaskMapper;
import mapper.UserMapper;
import repository.MySQLConfigure;
import repository.UserRepository;
import utilities.QueryBuilder;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MySQLUserRepo implements UserRepository {
    @Override
    public void createUser(User user) throws RuntimeException {
        if(user.getUsername() != null || user.getUsername().toLowerCase()!="null") {
            String userValues = "'" + user.getName() + "','" + user.getUsername() + "','" + user.getPassword() + "'";
            String query = new QueryBuilder().insert("users", userValues).build();
            MySQLConfigure.accessDatabase(MySQLConfigure.getConnection(), query);
        }else
            System.out.println("Username can't be null");
    }

    @Override
    public void updateUser(User user) throws RuntimeException {
        if(user.getUsername() != null) {
            Map<String, String> attributes = new HashMap<>();
            attributes.put("name", "'" + user.getName() + "'");
            attributes.put("username", "'" + user.getUsername() + "'");
            attributes.put("password_", "'" + user.getPassword() + "'");
            String updateQuery = new QueryBuilder().update("users").set(attributes).where("username='" + user.getUsername() + "'").build();
            MySQLConfigure.accessDatabase(MySQLConfigure.getConnection(), updateQuery);
        }else
            System.out.println("Username can't be null");
    }

    @Override
    public void deleteUser(String username) throws RuntimeException {
        String deleteQuery = new QueryBuilder()
                            .delete("users")
                            .where("username='" +  username + "'")
                            .build();
        MySQLConfigure.accessDatabase(MySQLConfigure.getConnection(),deleteQuery);
    }

    @Override
    public User getUserByUsername(String username) throws RuntimeException {
        Connection connection = MySQLConfigure.getConnection();
        String query = new QueryBuilder()
                        .select("*")
                        .from("users")
                        .where("username='" + username + "'")
                        .build();
        UserMapper userMapper = new UserMapper();
        return userMapper.getUser(query, connection);
    }
}
