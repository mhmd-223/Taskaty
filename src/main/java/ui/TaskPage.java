package ui;

import entity.Task;

public class TaskPage extends Page {
    private final Task task;

    public TaskPage(Task task) {
        this.task = task;
        configureContent();
    }

    @Override
    public String prompt() {
        return null;
    }

    @Override
    protected void configureContent() {
        content = """
                %s%s%s
                \t%s
                """.formatted(
                ConsoleColors.CYAN_BOLD,
                task.getTitle(),
                ConsoleColors.RESET,
                task.getDescription() == null ? "" : task.getDescription());
    }

    @Override
    protected void updateContent() {

    }
}
