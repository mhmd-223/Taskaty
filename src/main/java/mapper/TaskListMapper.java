package mapper;

import entity.Task;
import entity.TaskList;
import repository.MySQLConfigure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskListMapper implements TaskListMapperInterface {
    private TaskList taskList;

    @Override
    public TaskList getList(Connection connection,String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            TaskMapper taskMapper = new TaskMapper();
            DetailsMapper detailsMapper = new DetailsMapper();
            if (resultSet.next()) {
                taskList.setId(resultSet.getLong("Id"));
                taskList.setTitle(resultSet.getString("Title"));
/*                taskList.setTasks(taskMapper.getTasksOfList(resultSet.getLong("Id")));
                taskList.setDetails(detailsMapper.getDetailsOfList(resultSet.getLong("Id")));*/
                taskList.setTasks(null);
                taskList.setDetails(null);
            }
            resultSet.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return taskList;
    }
    public List<TaskList> getLists(Connection connection, String query) {
        List<TaskList> lists = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            TaskMapper taskMapper = new TaskMapper();
            DetailsMapper detailsMapper = new DetailsMapper();
            while (resultSet.next()) {
                taskList.setId(resultSet.getLong("Id"));
                taskList.setTitle(resultSet.getString("Title"));
/*                taskList.setTasks(taskMapper.getTasksOfList(resultSet.getLong("Id")));
                taskList.setDetails(detailsMapper.getDetailsOfList(resultSet.getLong("Id")));*/
                taskList.setTasks(null);
                taskList.setDetails(null);
                lists.add(taskList);
            }
            resultSet.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lists;
    }

}
