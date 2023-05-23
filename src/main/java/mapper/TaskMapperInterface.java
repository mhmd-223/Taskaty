package mapper;

import entity.Task;

import java.util.List;

public interface TaskMapperInterface {
    Task getTask(long id);

    List<Task> getAllTasks();

    List<Task> getTasksOfList(Long listId);
}
