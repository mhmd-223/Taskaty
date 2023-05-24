package command.parsingandvalidation;

import java.util.List;

public class SyntaxValidator extends CommandValidator {
    @Override
    public boolean validate(ParsedCommand command) {

        /* validate the command tag */
        if (command.command() == null) {
            setErrorMessage(Errors.UNSUPPORTED_COMMAND.formatted(command.tag()));
            return false;
        }

        /* validate args syntax */
        List<String> args = command.args();
        for (String arg : args) {
            if (propertyAssignmentValidation(arg))
                return false;

            if (matchedQuotesValidation(arg))
                return false;
        }

        /* syntax is correct */
        return true;
    }


    private boolean matchedQuotesValidation(String arg) {
        if (arg.contains("="))
            return false;

        if (arg.startsWith("\"") && !arg.endsWith("\"")) {
            setErrorMessage(Errors.UNCLOSED_QUOTE.formatted(arg));
            return true;
        }
        if (!arg.startsWith("\"") && arg.endsWith("\"")) {
            setErrorMessage(Errors.MISSING_OPENING_QUOTE.formatted(arg));
            return true;
        }
        return false;
    }

    private boolean propertyAssignmentValidation(String arg) {
        if (arg.endsWith("=")) {
            setErrorMessage(Errors.MISSING_VALUE_ASSIGNMENT.formatted(arg));
            return true;
        }
        if (arg.startsWith("=")) {
            setErrorMessage(Errors.MISSING_PROPERTY_NAME.formatted(arg));
            return true;
        }
        if (arg.contains("=")) {
            String[] keyValuePair = arg.split("=");
            if (!keyValuePair[1].startsWith("\"") && !keyValuePair[1].endsWith("\"")) {
                setErrorMessage(Errors.UNQUOTED_VALUE.formatted(keyValuePair[0]));
                return true;
            }
        }
        return false;
    }

}
