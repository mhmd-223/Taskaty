package command.commands;

import java.util.List;

public abstract class Command {

    private final int mandatoryArgsCount;
    private final boolean optionalArgsAllowed;

    private String errorMessage;

    public Command(int mandatoryArgsCount, boolean optionalArgsAllowed) {
        this.mandatoryArgsCount = mandatoryArgsCount;
        this.optionalArgsAllowed = optionalArgsAllowed;
    }

    public int getMandatoryArgsCount() {
        return mandatoryArgsCount;
    }

    public boolean isOptionalArgsAllowed() {
        return optionalArgsAllowed;
    }

    public abstract boolean execute(List<String> args);

    public abstract String getDescription();

    public abstract String getUsage();

    public String getErrorMessage() {
        return errorMessage;
    }

    private void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
