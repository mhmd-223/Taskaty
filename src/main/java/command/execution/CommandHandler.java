package command.execution;

import command.commands.Command;
import command.commands.CommandFactory;
import command.parsingandvalidation.*;

import java.util.List;

public class CommandHandler {
    private CommandValidator chain;
    private List<String> args;

    private String errorMessage;

    private void configureValidationChain() {
        chain = new SyntaxValidator();
        chain.setNextValidator(new ArgumentCountValidator());
    }

    public Command parseAndValidate(String input) {
        configureValidationChain();
        ParsedCommand command = Parser.parse(input);

        /* Go through the validation stages */
        while (chain != null) {
            if (!chain.validate(command)) {
                errorMessage = chain.getErrorMessage();
                return null;
            }
            chain = chain.getValidator();
        }
        args = command.args();

        return CommandFactory.createCommand(command.tag());
    }

    public List<String> getArgs() {
        return args;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
