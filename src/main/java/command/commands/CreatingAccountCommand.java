package command.commands;

import command.parsingandvalidation.Errors;
import entity.User;
import service.Registration;

import java.util.List;

public class CreatingAccountCommand extends Command{

    public CreatingAccountCommand() {
        super(2, false);
    }

    @Override
    public boolean execute(User user, List<String> args) {
        Registration registration = new Registration(userService);
        if (!registration.registerUser(user)) {
            if (registration.isExists())
                setErrorMessage(Errors.DUPLICATED_USERNAME);
            setErrorMessage("Failed to register a new account.");
            return false;
        }
        return true;
    }

    @Override
    public String getDescription() {
        return """
                This command creates a new user account.
                Users need to provide their name, a unique username and a secure password to register their account.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   newuser "<name>" "<username>" "<password>"
                Example: newuser "Muhammad" "mhmd" "securepassword"
                """;
    }
}
