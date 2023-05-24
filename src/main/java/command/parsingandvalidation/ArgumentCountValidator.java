package command.parsingandvalidation;

import command.commands.Command;

import java.util.List;

public class ArgumentCountValidator extends CommandValidator {
    @Override
    public boolean validate(ParsedCommand parsedCommand) {
        Command command = parsedCommand.command();
        int expectedCount = command.getMandatoryArgsCount();
        int providedCount = parsedCommand.args().size();

        if (command.isOptionalArgsAllowed() && expectedCount == 0) {
            return true;
        }

        if (expectedCount == 0 && providedCount != 0 && !command.isOptionalArgsAllowed()) {
            setErrorMessage(Errors.NO_ARGUMENTS_ALLOWED.formatted(parsedCommand.tag()));
            return false;
        }

        List<String> args = parsedCommand.args();
        if (!command.isOptionalArgsAllowed() && args.stream().anyMatch(arg -> arg.contains("="))) {
            setErrorMessage(Errors.NO_OPTIONAL_ARGUMENTS.formatted(parsedCommand.tag()));
            return false;
        }

        int mandatoryCount = (int) args.stream().filter(arg -> !arg.contains("=")).count();
        if (expectedCount != mandatoryCount) {
            setErrorMessage(Errors.INVALID_ARGUMENTS_COUNT.formatted(parsedCommand.tag(), expectedCount, mandatoryCount));
            return false;
        }

        return true;
    }

}
