package mapper;

import entity.User;

import java.sql.Connection;

public interface UserMapperInterface {
    User getUser(String query, Connection connection);
}
