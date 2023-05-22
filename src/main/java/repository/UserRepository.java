package repository;

import entity.User;

/**
 * Performs CRUD operations but for users.
 */
public interface UserRepository {
    void createUser(User user) throws RuntimeException;

    void updateUser(User user) throws RuntimeException;

    void deleteUser(User user) throws RuntimeException;

    User getUserByUsername(String username) throws RuntimeException;

}
