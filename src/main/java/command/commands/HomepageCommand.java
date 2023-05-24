package command.commands;

import java.util.List;

public class HomepageCommand extends Command {

    public HomepageCommand() {
        super(0, false);
    }

    @Override
    public boolean execute(List<String> args) {
        // TODO: takes user for the homepage
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
