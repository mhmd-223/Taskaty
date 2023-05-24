package command.commands;

import command.parsingandvalidation.Errors;
import entity.Task;
import entity.User;

import java.util.List;
import java.util.Map;

public class EditingTaskCommand extends Command {

    public EditingTaskCommand() {
        super(2, true);
    }

    @Override
    public boolean execute(User user, List<String> args) {
        List<Task> tasks = user.getTasks();
        Integer id = validate(args, tasks);
        if (id == null) return false;

        Map<String, String> argsValues = getArgsValues(args);
        Task task = tasks.get(id);
        for (String property : argsValues.keySet()) {
            if (property.equals("title"))
                task.setTitle(argsValues.get(property));
            if (property.startsWith("desc"))
                task.setTitle(argsValues.get(property));
        }

        boolean updatingResult = taskService.editTaskInfo(task);
        if (updatingResult) return true;
        setErrorMessage("Failed to update properties of task " + task.getTitle() + ".");
        return false;

    }

    private Integer validate(List<String> args, List<Task> tasks) {
        Integer id = validateId(args, tasks);
        if (id == null) return null;
        args.remove(0);
        for (String arg : args) {
            if (!arg.contains("=")) {
                setErrorMessage(Errors.MISSING_PROPERTY_NAME.formatted(arg));
                return null;
            }
        }
        return id;
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
