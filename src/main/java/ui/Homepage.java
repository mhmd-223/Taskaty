package ui;

import entity.Task;
import entity.TaskList;
import utilities.ConsoleIO;

import java.util.List;

public class Homepage extends Page {
    private final List<Task> tasks;
    private final List<Task> completedTasks;
    private final String name;
    private final List<TaskList> taskLists;

    public Homepage(String name, List<Task> tasks, List<Task> completedTasks, List<TaskList> taskLists) {
        this.tasks = tasks;
        this.name = name;
        this.completedTasks = completedTasks;
        this.taskLists = taskLists;
        configureContent();
    }

    @Override
    public String prompt() {
        return ConsoleIO.readLine(">> ");
    }

    @Override
    protected void configureContent() {
        String welcoming = """
                Welcome back, %s%s%s!
                                
                Time to conquer your tasks and make every moment count with Taskaty.
                                
                """.formatted(ConsoleColors.PURPLE_BOLD, name, ConsoleColors.RESET);

        String tasksMenu = showMenu("Your Tasks", "No tasks to show.", tasks, ConsoleColors.WHITE_BOLD);
        String listMenu = showMenu("Your Lists", "No lists to show.", taskLists, ConsoleColors.WHITE_BOLD);
        String completedTasks = showMenu("Your Completed Tasks", "No completed tasks yet.", tasks, this.completedTasks.isEmpty() ? ConsoleColors.WHITE_BOLD : ConsoleColors.STRIKETHROUGH);

        content = welcoming + tasksMenu + listMenu + completedTasks;
    }


    @Override
    protected void updateContent() {

    }
}
