package command.commands;

import java.util.List;

public class LoggingOutCommand extends Command {

    public LoggingOutCommand() {
        super(0, false);
    }
    @Override
    public boolean execute(List<String> args) {
        // TODO: log out user
        return true;

    }

    @Override
    public String getDescription() {
        return """
                This command logs the current user out of Taskaty.
                It ensures the user's account remains secure and prevents unauthorized access.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   logout
                Example: logout
                """;
    }
}
