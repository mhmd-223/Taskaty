package command.commands;

import java.util.List;

public class ExitingCommand extends Command {


    public ExitingCommand() {
        super(0, false);
    }

    @Override
    public boolean execute(List<String> args) {
        // TODO: 5/23/2023 exit application
        return true;

    }

    @Override
    public String getDescription() {
        return """
                This command exits Taskaty and closes command-line interface.
                It terminates the user's session and ends the interaction with the system.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   exit
                Example: exit
                """;
    }
}
