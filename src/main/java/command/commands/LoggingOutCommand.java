package command.commands;

import service.Session;
import ui.LaunchingPage;
import ui.Page;

import java.util.List;

public class LoggingOutCommand extends Command {

    public LoggingOutCommand() {
        super(0, false);
    }

    @Override
    public boolean execute(Session session, List<String> args) {
        session.setPage(new LaunchingPage());
        return true;

    }

    @Override
    public String getDescription() {
        return """
                logout:  This command logs the current user out of Taskaty.
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
