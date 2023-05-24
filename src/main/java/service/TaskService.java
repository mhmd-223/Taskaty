package service;

import entity.Task;
import repository.TaskRepository;

import java.util.List;

/**
 * Implements the business logic for task-related operations, such as creating, updating, and deleting tasks.
 * It interacts with the data access layer and performs validation and business rules.
 * It depends on TaskRepository, having a composition relationship
 */
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public boolean addTask(Task task) {
        try {
            repository.createTask(task);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean editTaskInfo(Task task) {
        try {
            repository.updateTask(task);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public List<Task> getListTasks(Long listID) {
        try {
            return repository.getTasksByListID(listID);
        } catch (RuntimeException e) {
            return null;
        }
    }

    public List<Task> getAllTasks(String userID) {
        try {
            return repository.getTasksByUserID(userID);
        } catch (RuntimeException e) {
            return null;
        }
    }

    public boolean deleteTask(Task task) {
        try {
            repository.deleteTask(task.getId());
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
