package command.commands;

import entity.Task;
import entity.TaskList;
import entity.User;
import ui.Page;
import ui.TaskPage;

import java.util.List;

public class OpeningTaskCommand extends Command {

    public OpeningTaskCommand() {
        super(1, false);
    }

    @Override
    public boolean execute(User user, List<String> args) {
        List<Task> tasks = user.getTasks();
        Integer providedID = validateId(args, tasks);
        if (providedID == null) return false;
        Page taskPage = new TaskPage(tasks.get(providedID));
        taskPage.refresh();
        return true;

    }

    @Override
    public String getDescription() {
        return """
                open: Open a specific task from your task list for detailed viewing.
                      Provide the ordinal of the task you want to open, and the system will display comprehensive
                      information about the task, including its title, description, due date, and any other relevant details.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   open <taskOrdinal>
                Example: open 1
                """;
    }
}
