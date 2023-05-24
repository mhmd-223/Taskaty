package command.execution;

import command.commands.Command;
import command.commands.CommandFactory;
import command.parsingandvalidation.*;
import utilities.ConsoleIO;

public class CommandHandler {
    private static CommandValidator chain;

    public static Command parseAndValidate(String input) {
        configureValidationChain();
        ParsedCommand command = Parser.parse(input);

        /* Go through the validation stages */
        while (chain != null) {
            if (!chain.validate(command)) {
                ConsoleIO.printError(chain.getErrorMessage());
                return null;
            }
            chain = chain.getValidator();
        }

        return CommandFactory.createCommand(command.tag());
    }

    private static void configureValidationChain() {
        chain = new SyntaxValidator();
        chain.setNextValidator(new ArgumentCountValidator());
    }
}
