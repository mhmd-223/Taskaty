package command.commands;

import entity.Task;
import entity.TaskBuilder;
import service.Session;
import utilities.StringUtils;

import java.util.List;

public class AddingTaskCommand extends Command {

    public AddingTaskCommand() {
        super(1, false);
    }

    @Override
    public boolean execute(Session session, List<String> args) {

        Task task = new TaskBuilder()
                .setTitle(StringUtils.removeQuotes(args.get(0)))
                .setUserId(session.getUser().getUsername())
                .createTask();

        boolean addingResult = taskService.addTask(task);
        if (addingResult)
            return true;
        setErrorMessage("Failed to add a new task.");
        return false;

    }


    @Override
    public String getDescription() {
        return """
                addtask: This command allows users to add a new task to their task list.
                         Users need to provide a title for the task.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   addtask "<Title>"
                Example: addtask "Buy groceries"
                """;
    }
}
