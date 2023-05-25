package command.commands;

import entity.Task;
import entity.TaskList;
import entity.User;
import ui.ConsoleColors;

import java.util.List;

public class MovingTaskCommand extends Command {

    public MovingTaskCommand() {
        super(2, false);
    }

    @Override
    public boolean execute(User user, List<String> args) {
        List<Task> tasks = user.getTasks();
        List<TaskList> lists = user.getTaskLists();

        Integer taskID = validateId(args, tasks);
        if (taskID == null)
            return false;
        args.remove(0);

        Integer listID = validateId(args, lists);
        if (listID == null)
            return false;

        Task task = tasks.get(taskID);
        TaskList list = lists.get(listID);
        task.setListId(list.getId());

        boolean movingResult = taskService.editTaskInfo(task);
        if (movingResult) return true;
        setErrorMessage("Failed to moving task " + task.getTitle() + " to the list " + list.getTitle());
        return false;

    }

    @Override
    public String getDescription() {
        return """
                move:  With this command, users can move a specific task from one list to another.
                       Users need to provide the ordinal of the task they want to move and specify the ordinal of the destination list.
                       Ordinals which are displayed on HOMEPAGE
                """;
    }

    @Override
    public String getUsage() {
        return """  
                Usage:   move <TaskOrdinal> <ListOrdinal>
                Example: move 1 4
                """;
    }
}
