package command.execution;

import command.commands.Command;
import entity.User;

import java.util.List;

public class CommandExecutor {
    private CommandExecutor() {
        /* Prevent instantiation */
    }

    public static ExecutionResult executeCommand(Command command, List<String> args, User user) {
        boolean status = command.execute(user,args);
        if (status)
            return ExecutionResult.success();
        else
            return ExecutionResult.failure(command.getErrorMessage());
    }
}
