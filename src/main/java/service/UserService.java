package service;

import entity.User;
import repository.UserRepository;
import utilities.ConsoleIO;
import utilities.PasswordHashing;

/**
 * Same as TaskService but for users.
 */
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    private static void validatePassword(User user) {
        String pass = ConsoleIO.readSecuredPassword("Password >> ");
        while (!PasswordHashing.isMatch(pass, user.getPassword())) {
            ConsoleIO.printError("Wrong password for " + user.getUsername() + " account.");
            pass = ConsoleIO.readSecuredPassword("Password >> ");
        }
    }

    public boolean registerUser(User user) {
        user.setPassword(PasswordHashing.hash(user.getPassword()));
        try {
            repository.createUser(user);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean editName(User user, String newName) {
        try {
            validatePassword(user);
            user.setName(newName);
            repository.updateUser(user);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean editUsername(User user, String newUsername) {
        try {
            validatePassword(user);
            user.setUsername(newUsername);
            repository.updateUser(user);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean editPassword(User user, String newPassword) {
        try {
            validatePassword(user);
            user.setPassword(PasswordHashing.hash(newPassword));
            repository.updateUser(user);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean deleteAccount(User user) {
        try {
            validatePassword(user);
            repository.deleteUser(user.getUsername());
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public User retrieveAccount(String username) {
        try {
            return repository.getUserByUsername(username);
        } catch (RuntimeException e) {
            return null;
        }
    }

}
