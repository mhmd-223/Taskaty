package service;

import entity.User;
import repository.mysql.MySQLListRepo;
import repository.mysql.MySQLTaskRepo;
import ui.Homepage;
import ui.LaunchingPage;
import ui.Page;

public class Session {
    private final User user;
    private boolean loggedIn;

    private TaskService taskService;
    private ListService listService;

    public Session(User user) {
        this.user = user;
        taskService = new TaskService(new MySQLTaskRepo());
        listService = new ListService(new MySQLListRepo());
    }

    public void start() {
        loggedIn = true;
        user.setTasks(taskService.getAllTasks(user.getUsername()));
        user.setTaskLists(listService.getLists(user.getUsername()));
        Page homePage = new Homepage(user);
        homePage.refresh();
    }

    public void end() {
        loggedIn = false;
        Page launchingPage = new LaunchingPage();
        launchingPage.display();
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
}
