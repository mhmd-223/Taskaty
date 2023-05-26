package command.commands;

import entity.Task;
import service.Session;
import ui.TaskPage;

import java.util.List;

public class OpeningTaskCommand extends Command {

    public OpeningTaskCommand() {
        super(1, false);
    }

    @Override
    public boolean execute(Session session, List<String> args) {
        List<Task> tasks = session.getUser().getTasks();
        Integer providedID = validateId(args, tasks);
        if (providedID == null) return false;
        session.setPage(new TaskPage(providedID, session.getUser()));
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
