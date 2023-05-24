package mapper;

import entity.Task;

import java.sql.Connection;
import java.util.List;

public interface TaskMapperInterface {
    Task getTask( Connection connection,String query);

    List<Task> getTasks(Connection connection, String query);

    List<Task> getTasksOfList(Long listId);
}
