package command.commands;

import entity.Task;
import entity.TaskBuilder;
import entity.User;

import java.util.List;
import java.util.Map;

public class AddingTaskCommand extends Command {

    public AddingTaskCommand() {
        super(1, false);
    }

    @Override
    public boolean execute(User user, List<String> args) {

        Task task = new TaskBuilder()
                .setTitle(removeQuotes(args.get(0)))
                .setUserId(user.getUsername())
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
