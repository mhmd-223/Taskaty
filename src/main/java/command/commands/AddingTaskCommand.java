package command.commands;

import java.util.List;

public class AddingTaskCommand extends Command {

    public AddingTaskCommand() {
        super(1, true);
    }

    @Override
    public boolean execute(List<String> args) {
        // TODO: Adding task execution
        return true;

    }

    @Override
    public String getDescription() {
        return """
                This command allows users to add a new task to their task list.
                Users need to provide a title for the task, and they can optionally
                include additional information such as a description, due date, and other relevant details.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   addtask "<Title>" [description="Description"] [...]
                Example: addtask "Buy groceries" description="Remember to buy milk, eggs, and bread"
                """;
    }
}
