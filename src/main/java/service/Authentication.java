package service;

import entity.User;
import repository.UserRepository;
import repository.mysql.MySQLUserRepo;
import utilities.PasswordHashing;

public class Authentication {

    private User user;
    private final UserService service;
    private boolean wrongUsername, wrongPassword;

    public Authentication(User user, UserRepository repository) {
        this.user = user;
        service = new UserService(repository);

    }

    public Authentication(User user) {
        this(user, new MySQLUserRepo());
    }

    public boolean isAuthenticated() {
        User stored = service.retrieveAccount(user.getUsername());
        if (stored.getUsername() == null) {
            wrongUsername = true;
            return false;
        }
        wrongPassword = !PasswordHashing.isMatch(user.getPassword(), stored.getPassword());
        if (!wrongPassword) {
            user = stored;
            return true;
        }
        return false;
    }

    public boolean isWrongUsername() {
        return wrongUsername;
    }

    public boolean isWrongPassword() {
        return wrongPassword;
    }

    public User getUser() {
        return user;
    }
}
