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
    private TaskList taskList = new TaskList();

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
                taskList.setUsername(resultSet.getString("username"));
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
                TaskList taskList1 = new TaskList();
                taskList1.setId(resultSet.getLong("id"));
                taskList1.setTitle(resultSet.getString("title"));
                taskList1.setUsername(resultSet.getString("username"));
/*                taskList.setTasks(taskMapper.getTasksOfList(resultSet.getLong("Id")));
                taskList.setDetails(detailsMapper.getDetailsOfList(resultSet.getLong("Id")));*/
                taskList1.setTasks(null);
                taskList1.setDetails(null);
                lists.add(taskList1);
            }
            resultSet.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lists;
    }

}
