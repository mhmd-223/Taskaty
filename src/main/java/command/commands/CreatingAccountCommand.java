package command.commands;

import command.parsingandvalidation.Errors;
import entity.User;
import service.Registration;
import service.Session;
import ui.Homepage;
import utilities.StringUtils;

import java.util.List;

public class CreatingAccountCommand extends Command {

    public CreatingAccountCommand() {
        super(2, false);
    }

    @Override
    public boolean execute(Session session, List<String> args) {
        User user = session.getUser();
        user.setName(StringUtils.removeQuotes(args.get(0)));
        user.setUsername(StringUtils.removeQuotes(args.get(1)));
        Registration registration = new Registration(userService);
        if (!registration.registerUser(user)) {
            if (registration.isExists())
                setErrorMessage(Errors.DUPLICATED_USERNAME);
            else
                setErrorMessage("Failed to register a new account.");
            return false;
        }
        session.setPage(new Homepage(user));
        return true;
    }

    @Override
    public String getDescription() {
        return """
                newuser:  This command creates a new user account.
                          Users need to provide their name and a unique username.
                          Then they will be prompted to provide a password.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   newuser "<name>" "<username>"
                Example: newuser "Muhammad" "mhmd"
                """;
    }
}
