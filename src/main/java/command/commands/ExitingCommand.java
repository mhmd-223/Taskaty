package command.commands;

import entity.User;
import utilities.ConsoleIO;

import java.util.List;

public class ExitingCommand extends Command {


    public ExitingCommand() {
        super(0, false);
    }

    @Override
    public boolean execute(User user, List<String> args) {
        ConsoleIO.printDocumentation("""
                                
                Thank you for using Taskaty! Remember, every completed task brings you closer to your goals. See you next time!
                                
                - The Taskaty Team
                """);

        System.exit(0);
        return true;
    }

    @Override
    public String getDescription() {
        return """
                exit:  This command exits Taskaty.
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
