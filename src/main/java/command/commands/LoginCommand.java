package command.commands;

import command.parsingandvalidation.Errors;
import entity.User;
import service.Authentication;

import java.util.List;

public class LoginCommand extends Command {

    public LoginCommand() {
        super(1, false);
    }

    @Override
    public boolean execute(User user, List<String> args) {
        Authentication authentication = new Authentication(user);
        if (!authentication.isAuthenticated()) {
            if (authentication.isWrongPassword()) {
                setErrorMessage(Errors.WRONG_PASSWORD);
                return false;
            }
            setErrorMessage(Errors.WRONG_USERNAME);
            return false;
        }
        return true;
    }

    @Override
    public String getDescription() {
        return """
                The login command is used to authenticate and log in to your user account in Taskaty.
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
}
