package ui;

import entity.Task;
import entity.TaskList;
import entity.User;
import utilities.StringUtils;

import java.util.List;

public class Homepage extends Page {
    private List<Task> tasks;
    private String name;
    private List<TaskList> taskLists;

    public Homepage(User user) {
        super.user = user;
        initialize();
        configureContent();
    }

    private void initialize() {
        tasks = user.getTasks();
        name = user.getName();
        taskLists = user.getTaskLists();
    }


    @Override
    protected void configureContent() {
        initialize();
        String welcoming = """
                Welcome back, %s%s%s!
                                
                Time to conquer your tasks and make every moment count with Taskaty.
                                
                """.formatted(ConsoleColors.PURPLE_BOLD, StringUtils.titleCase(name), ConsoleColors.RESET);

        String tasksMenu = showMenu("Your Tasks", "No tasks to show.", tasks);
        String listMenu = showMenu("Your Lists", "No lists to show.", taskLists);

        content = welcoming + tasksMenu + listMenu;
    }

}
