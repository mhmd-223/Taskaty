package command.commands;

import command.parsingandvalidation.Errors;
import entity.User;
import utilities.ConsoleIO;

import java.util.List;

public class HelpCommand extends Command {

    public HelpCommand() {
        super(0, true);
    }

    private void extractDescAndUsage(Command command) {
        ConsoleIO.printDocumentation(command.getDescription());
        ConsoleIO.printDocumentation(command.getUsage());
        ConsoleIO.printDocumentation("---------------------");
    }

    @Override
    public boolean execute(User user, List<String> args) {
        Command command;
        if (args.isEmpty()) {
            for (Class<? extends Command> value : CommandFactory.getCommands().values()) {
                try {
                    command = value.getDeclaredConstructor().newInstance();
                    extractDescAndUsage(command);
                } catch (Exception e) {
                    setErrorMessage("Something wrong occurred.");
                    return false;
                }
            }
        } else {
            for (String arg : args) {
                command = CommandFactory.createCommand(arg);
                if (command == null) {
                    setErrorMessage(Errors.UNSUPPORTED_COMMAND.formatted(arg));
                    return false;
                }
                extractDescAndUsage(command);
            }
        }
        return true;

    }

    @Override
    public String getDescription() {
        return """
                help:  This command provides assistance and instructions for using Taskaty.
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
