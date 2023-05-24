package command.execution;

import command.commands.Command;

import java.util.List;

public class CommandExecutor {
    private CommandExecutor() {
        /* Prevent instantiation */
    }

    public static ExecutionResult executeCommand(Command command, List<String> args) {
        boolean status = command.execute(null,args);
        if (status)
            return ExecutionResult.success();
        else
            return ExecutionResult.failure(command.getErrorMessage());
    }
}
