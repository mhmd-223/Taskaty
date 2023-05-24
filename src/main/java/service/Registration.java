package service;

import entity.User;

public class Registration {
    private final UserService service;
    private boolean exists;

    public Registration(UserService service) {
        this.service = service;
    }

    public boolean registerUser(User user) {

        /* Check if the username is already taken */
        if (service.retrieveAccount(user.getUsername()).getUsername() != null) {
            exists = true;
            return false;
        }
        exists = false;
        return service.registerUser(user);
    }

    public boolean isExists() {
        return exists;
    }

}
