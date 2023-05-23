package repository;

import entity.TaskList;

import java.util.List;

public interface ListRepository {
    void createTaskList(TaskList taskList) throws RuntimeException;

    void updateTaskList(TaskList taskList) throws RuntimeException;

    void deleteTaskList(Long taskListId) throws RuntimeException;

    List<TaskList> getListsByUserId(String userId) throws RuntimeException;

    boolean existsById(Long id) throws RuntimeException;

}
