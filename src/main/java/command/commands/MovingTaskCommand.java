package command.commands;

import entity.Task;
import entity.TaskList;
import entity.User;

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
                With this command, users can move a specific task from one list to another.
                Users need to provide the ID of the task they want to move and specify the name of the destination list.
                """;
    }

    @Override
    public String getUsage() {
        return """  
                Usage:   move <TaskID> "<ListName>"
                Example: move 1 "In Progress"
                """;
    }
}
