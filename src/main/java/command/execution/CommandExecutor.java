package command.execution;

import command.commands.Command;
import service.Session;

import java.util.List;

public class CommandExecutor {
    private CommandExecutor() {
        /* Prevent instantiation */
    }

    public static ExecutionResult executeCommand(Command command, List<String> args, Session session) {
        boolean status = command.execute(session,args);
        if (status)
            return ExecutionResult.success();
        else
            return ExecutionResult.failure(command.getErrorMessage());
    }
}
