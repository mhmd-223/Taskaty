package entity;

import java.util.List;

public class TaskList {
    private Long id;
    private String title;
    private String username;
    private List<Task> tasks;
    private List<Detail> details;

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", tasks=" + tasks +
                ", details=" + details +
                '}';
    }

    public TaskList() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TaskList(Long id, String title, String username, List<Task> tasks, List<Detail> details) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.tasks = tasks;
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
