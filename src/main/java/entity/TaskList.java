package entity;

import java.util.List;

public class TaskList {
    private String id;
    private String title;
    private List<Task> tasks;
    private List<Detail> details;

    public TaskList() {
    }

    public TaskList(String id, String title, List<Task> tasks, List<Detail> details) {
        this.id = id;
        this.title = title;
        this.tasks = tasks;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
