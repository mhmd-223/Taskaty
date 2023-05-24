package command.commands;

import entity.User;
import ui.Homepage;
import ui.Page;

import java.util.List;

public class HomepageCommand extends Command {

    public HomepageCommand() {
        super(0, false);
    }

    @Override
    public boolean execute(User user, List<String> args) {
        Page homepage = new Homepage(user);
        homepage.refresh();
        return true;

    }

    @Override
    public String getDescription() {
        return """
                This command takes users back to the home screen or the main menu of Taskaty.
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
