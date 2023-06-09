package command.commands;

import entity.Task;
import service.Session;

import java.util.List;

public class DeletingTaskCommand extends Command {

    public DeletingTaskCommand() {
        super(1, false);
    }


    @Override
    public boolean execute(Session session, List<String> args) {
        List<Task> tasks = session.getUser().getTasks();
        Integer id = validateId(args, tasks);
        if (id == null)
            return false;
        boolean deletingResult = taskService.deleteTask(tasks.get(id));
        if (deletingResult)
            return true;
        setErrorMessage("Failed to delete task " + tasks.get(id).getTitle());
        return false;
    }

    @Override
    public String getDescription() {
        return """
                deletetask:  This command allows users to delete a task from their task list.
                             Users need to provide the ID of the task they want to remove,which is the ordinal of it on HOMEPAGE,
                             and the system will permanently delete it.
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
