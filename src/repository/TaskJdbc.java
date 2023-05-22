package repository;

import entity.Task;

import java.util.List;

public class TaskJdbc implements TaskRepository{

    @Override
    public void createTask(Task task) throws RuntimeException {

    }

    @Override
    public void updateTask(Task task) throws RuntimeException {

    }

    @Override
    public void deleteTask(Task task) throws RuntimeException {

    }

    @Override
    public List<Task> getTasksByListID(Long listId) throws RuntimeException {
        return null;
    }

    @Override
    public List<Task> getTasksByUserID(String userId) throws RuntimeException {
        return null;
    }

    @Override
    public boolean existsById(Long id) throws RuntimeException {
        return false;
    }
}
