package repository;

import entity.Task;

import java.util.List;


/**
 * This interface will provide abstraction for data accessing in the database.
 * It will provide CRUD operations on tasks.
 * It is crucial to switch between MySQL and mongodb
 */
public interface TaskRepository {
    void createTask(Task task) throws RuntimeException;

    void updateTask(Task task) throws RuntimeException;


    void deleteTask(Task task) throws RuntimeException;

    List<Task> getTasksByListID(Long listId) throws RuntimeException;

    List<Task> getTasksByUserID(String userId) throws RuntimeException;

    boolean existsById(Long id) throws RuntimeException;

}
