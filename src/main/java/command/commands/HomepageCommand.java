package command.commands;

import service.Session;
import ui.Homepage;
import ui.Page;

import java.util.List;

public class HomepageCommand extends Command {

    public HomepageCommand() {
        super(0, false);
    }

    @Override
    public boolean execute(Session session, List<String> args) {
        session.setPage(new Homepage(session.getUser()));
        return true;
    }

    @Override
    public String getDescription() {
        return """
                home:  This command takes users back to the home screen or the main menu of Taskaty.
                       It provides a central starting point for accessing various commands and features.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   home
                Example: home
                """;
    }
}
