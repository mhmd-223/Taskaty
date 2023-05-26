package service;

import entity.User;
import repository.mysql.MySQLListRepo;
import repository.mysql.MySQLTaskRepo;
import ui.Page;

public class Session {
    private User user;
    private boolean loggedIn;
    private Page page;
    private TaskService taskService;
    private ListService listService;

    public Session(User user) {
        this.user = user;
        taskService = new TaskService(new MySQLTaskRepo());
        listService = new ListService(new MySQLListRepo());
    }

    public Session() {
        this(null);
    }

    public void start() {
        loggedIn = true;
        user.setTasks(taskService.getAllTasks(user.getUsername()));
        user.setTaskLists(listService.getLists(user.getUsername()));
        page.updateContent(user);
    }

    public void end() {
        loggedIn = false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public void setListService(ListService listService) {
        this.listService = listService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void refreshUser() {
        user.setTasks(taskService.getAllTasks(user.getUsername()));
        user.setTaskLists(listService.getLists(user.getUsername()));
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
