package ui;

import entity.TaskList;
import entity.User;

public class ListPage extends Page {
    private final Integer listID;

    public ListPage(Integer listID, User user) {
        this.listID = listID;
        super.user = user;
        configureContent();
    }


    @Override
    protected void configureContent() {
        TaskList list = user.getTaskLists().get(listID);
        String tasks = showMenu(list.getTitle(), "No tasks to show.", list.getTasks());
        String details = showMenu("Details", "You didn't set any details to this list.", list.getDetails());
        content = tasks + details;
    }

}
