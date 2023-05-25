package ui;

import entity.Task;
import entity.TaskList;
import entity.User;

import java.util.List;

public class Homepage extends Page {
    private final List<Task> tasks;
    private final String name;
    private final List<TaskList> taskLists;

    public Homepage(User user) {
        tasks = user.getTasks();
        name = user.getName();
        this.taskLists = user.getTaskLists();
        configureContent();
    }


    @Override
    protected void configureContent() {
        String welcoming = """
                Welcome back, %s%s%s!
                                
                Time to conquer your tasks and make every moment count with Taskaty.
                                
                """.formatted(ConsoleColors.PURPLE_BOLD, name, ConsoleColors.RESET);

        String tasksMenu = showMenu("Your Tasks", "No tasks to show.", tasks);
        String listMenu = showMenu("Your Lists", "No lists to show.", taskLists);

        content = welcoming + tasksMenu + listMenu;
    }


    @Override
    protected void updateContent() {

    }
}
