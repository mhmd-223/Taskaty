package command.commands;

import java.util.List;

public class OpeningTaskCommand extends Command{

    public OpeningTaskCommand() {
        super(1, false);
    }
    @Override
    public boolean execute(List<String> args) {
        // TODO: open task
        return true;

    }

    @Override
    public String getDescription() {
        return """
                Open a specific task from your task list for detailed viewing.
                Provide the ID of the task you want to open, and the system will display comprehensive
                information about the task, including its title, description, due date, and any other relevant details.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   open <taskId>
                Example: open 1
                """;
    }
}
