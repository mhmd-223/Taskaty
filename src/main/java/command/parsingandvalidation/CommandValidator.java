package command.parsingandvalidation;

public abstract class CommandValidator {
    private CommandValidator validator;
    private String errorMessage;

    public abstract boolean validate(ParsedCommand command);

    public void setNextValidator(CommandValidator validator) {
        this.validator = validator;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    protected void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public CommandValidator getValidator() {
        return validator;
    }
}
