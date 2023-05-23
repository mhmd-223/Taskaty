package mapper;

import entity.Task;
import repository.MySQLConfigure;
import utilities.QueryBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskMapper implements TaskMapperInterface {
    private final Task task = new Task();

    @Override
    public Task getTask(Connection connection,String query) {

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                task.setId(resultSet.getLong("Id"));
                task.setCompleted(resultSet.getBoolean("Completed"));
                task.setDescription(resultSet.getString("Description"));
                task.setTitle(resultSet.getString("Title"));
                task.setListId(resultSet.getLong("ListId"));
                task.setUserId(resultSet.getString("UserId"));
            }
            resultSet.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return task;
    }


    public List<Task> getTasks(Connection connection, String query) {
        List<Task> tasks = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                task.setId(resultSet.getLong("id"));
                task.setCompleted(resultSet.getBoolean("Completed"));
                task.setDescription(resultSet.getString("Description"));
                task.setTitle(resultSet.getString("Title"));
                task.setListId(resultSet.getLong("ListId"));
                task.setUserId(resultSet.getString("UserId"));
                tasks.add(task);
            }
            resultSet.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }

    @Override
    public List<Task> getTasksOfList(Long listId) {
        Connection connection = MySQLConfigure.getConnection();
        String query = new QueryBuilder()
                .select("*")
                .from("task")
                .where("listid" + listId)
                .build();
        return getTasks(connection, query);
    }
}
