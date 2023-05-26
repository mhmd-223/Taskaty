package ui;

import entity.Task;
import entity.User;

public class TaskPage extends Page {

    private final int taskID;

    public TaskPage(int taskID, User user) {
        this.taskID = taskID;
        super.user = user;
        configureContent();
    }

    @Override
    protected void configureContent() {
        Task task = user.getTasks().get(taskID);
        content = """
                %s%s%s
                                
                \t%s
                """.formatted(
                ConsoleColors.CYAN_BOLD,
                task.getTitle(),
                ConsoleColors.RESET,
                task.getDescription().equals("null") ? "No description added." : task.getDescription());
    }

}
