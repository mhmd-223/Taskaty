package command.commands;

import entity.Task;
import entity.TaskBuilder;
import entity.User;

import java.util.List;
import java.util.Map;

public class AddingTaskCommand extends Command {

    public AddingTaskCommand() {
        super(1, true);
    }

    @Override
    public boolean execute(User user, List<String> args) {
        Map<String, String> argsValues = getArgsValues(args);
        if (argsValues == null) return false;
        Task task = new TaskBuilder().setTitle(argsValues.get("title"))
                .setDescription(argsValues.get("desc"))
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
