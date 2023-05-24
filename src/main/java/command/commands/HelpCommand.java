package command.commands;

import java.util.List;

public class HelpCommand extends Command{

    public HelpCommand(){
        super(0, true);
    }

    @Override
    public boolean execute(List<String> args) {
        // TODO: display help for users
        return true;

    }

    @Override
    public String getDescription() {
        return """
                This command provides assistance and instructions for using Taskaty.
                Users can provide an optional command parameter to get more detailed information about a specific command.
                """;
    }

    @Override
    public String getUsage() {
        return """           
                Usage:   help [command]
                Example: help "addtask" or help
                """;
    }
}
