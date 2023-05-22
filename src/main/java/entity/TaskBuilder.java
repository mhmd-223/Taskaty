package entity;

public class TaskBuilder {
    private Long id;
    private Long listId;
    private String title;
    private String description;
    private String userId;
    private boolean completed;

    public TaskBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public TaskBuilder setListId(Long listId) {
        this.listId = listId;
        return this;
    }

    public TaskBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public TaskBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public TaskBuilder setCompleted(boolean completed) {
        this.completed = completed;
        return this;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Task createTask() {
        return new Task(id, listId, title, description, userId, completed);
    }
}