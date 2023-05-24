package command.commands;

import java.util.List;

public class EditingTaskCommand extends Command{

    public EditingTaskCommand() {
        super(2, true);
    }

    @Override
    public boolean execute(List<String> args) {
        // TODO: Editing task execution
        return true;

    }

    @Override
    public String getDescription() {
        return """
                This command enables users to edit an existing task in their task list.
                Users need to specify the task's ID (which corresponds to its position in the displayed menu)
                and provide the updated information such as the new title, description, or any other desired modifications.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   edittask <id> [title="New Title"] ["description"="New Description"] [...]
                Example: edittask 1 title="New task title" description="Updated task description"
                """;
    }
}
