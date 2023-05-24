package command.execution;

public class ExecutionResult {
    private final boolean success;
    private final String errorMessage;

    private ExecutionResult(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public static ExecutionResult success() {
        return new ExecutionResult(true, null);
    }

    public static ExecutionResult failure(String errorMessage) {
        return new ExecutionResult(false, errorMessage);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
