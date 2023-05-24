package command.commands;

import java.util.List;

public class DeletingTaskCommand extends Command{

    public DeletingTaskCommand() {
        super(1, false);
    }

    @Override
    public boolean execute(List<String> args) {
        // TODO: delete task
        return true;

    }

    @Override
    public String getDescription() {
        return """
                This command allows users to delete a task from their task list.
                Users need to provide the ID of the task they want to remove, and the system will permanently delete it.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   deletetask <taskID>
                Example: deletetask 3
                """;
    }
}
