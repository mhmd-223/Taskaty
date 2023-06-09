package command.commands;

import entity.Task;
import service.Session;
import ui.ConsoleColors;

import java.util.List;

public class MarkingCompletedCommand extends Command {

    public MarkingCompletedCommand() {
        super(1, false);
    }

    @Override
    public boolean execute(Session session, List<String> args) {
        List<Task> tasks = session.getUser().getTasks();
        Integer id = validateId(args, tasks);
        if (id == null) return false;

        Task task = tasks.get(id);
        if (task.isCompleted()) {
            setErrorMessage("Task is already completed.");
            return false;
        }
        task.setCompleted(true);
        task.setTitle(ConsoleColors.STRIKETHROUGH + task.getTitle() + ConsoleColors.RESET);
        boolean marked = taskService.editTaskInfo(task);
        if (marked)
            return true;
        setErrorMessage("Failed to mark task " + task.getTitle() + " as completed.");
        return false;

    }

    @Override
    public String getDescription() {
        return """
                This command marks a task as completed.
                Users need to specify the ID of the task they want to mark as complete,
                and the system will update the task's status accordingly.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   complete <id>
                Example: complete 2
                """;
    }
}
