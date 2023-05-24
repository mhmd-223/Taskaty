package command.commands;

import java.util.List;

public class ShowingTasksCommand extends Command{

    public ShowingTasksCommand() {
        super(1, false);
    }

    @Override
    public boolean execute(List<String> args) {
        // TODO: Showing tasks execution
        return true;

    }

    @Override
    public String getDescription() {
        return """
                This command displays all the tasks in a specific list.
                Users need to provide the name of the list they want to view,
                and the command will present the tasks along with their IDs, titles, and other details.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   showtasks "<listName>"
                Example: showtasks "Today"
                """;
    }
}
