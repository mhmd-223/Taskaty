package command.commands;

import java.util.List;

public class CreatingAccountCommand extends Command{

    public CreatingAccountCommand() {
        super(3, false);
    }

    @Override
    public boolean execute(List<String> args) {
        // TODO: create a new user, logout the current user and log in the new user
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
