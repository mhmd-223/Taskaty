package command.commands;

import java.util.List;

public class MarkingCompletedCommand extends Command {

    public MarkingCompletedCommand() {
        super(1, false);
    }
    @Override
    public boolean execute(List<String> args) {
        // TODO: mark task as completed
        return true;

    }

    @Override
    public String getDescription() {
        return """
                This command marks a task as completed.
                Users need to specify the ID of the task they want to mark as complete,
                and the system will update the task's status accordingly.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   complete <id>
                Example: complete 2
                """;
    }
}
