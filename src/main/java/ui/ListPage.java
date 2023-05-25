package ui;

import entity.TaskList;

public class ListPage extends Page {
    private final TaskList list;

    public ListPage(TaskList list) {
        this.list = list;
        configureContent();
    }


    @Override
    protected void configureContent() {
        String tasks = showMenu(list.getTitle(), "No tasks to show.", list.getTasks());
        String details = showMenu("Details", "You didn't set any details to this list.", list.getDetails());
        content = tasks + details;
    }


    @Override
    protected void updateContent() {

    }
}
