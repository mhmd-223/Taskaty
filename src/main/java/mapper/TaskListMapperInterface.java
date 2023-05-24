package mapper;

import entity.TaskList;

import java.sql.Connection;

public interface TaskListMapperInterface {
    TaskList getList( Connection connection,String query);
}
