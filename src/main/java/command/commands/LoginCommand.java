package command.commands;

import command.parsingandvalidation.Errors;
import entity.User;
import service.Authentication;
import service.Session;
import ui.Homepage;

import java.util.List;

public class LoginCommand extends Command {

    private User successfulLoggedUser;

    public LoginCommand() {
        super(1, false);
    }

    @Override
    public boolean execute(Session session, List<String> args) {
        session.getUser().setUsername(args.get(0));
        Authentication authentication = new Authentication(session.getUser());
        if (!authentication.isAuthenticated()) {
            if (authentication.isWrongPassword()) {
                setErrorMessage(Errors.WRONG_PASSWORD);
                return false;
            }
            setErrorMessage(Errors.WRONG_USERNAME);
            return false;
        }
        User user = authentication.getUser();
        session.setUser(user);
        session.refreshUser();
        session.setPage(new Homepage(user));
        return true;
    }

    @Override
    public String getDescription() {
        return """
                login:  The login command is used to authenticate and log in to your user account in Taskaty.
                        After providing your username, you will be prompted to securely type your password.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   login <username>
                Example: login mhmd
                """;
    }

    public User getSuccessfulLoggedUser() {
        return successfulLoggedUser;
    }
}
