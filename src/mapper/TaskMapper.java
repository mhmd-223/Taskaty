package mapper;

import entity.Task;
import repository.JdbcConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskMapper implements TaskMapperInterface {
    private Task task = new Task();

    @Override
    public Task getTask(long id) {
        Connection connection = JdbcConfig.getConnection();
        String query = "Select * from Task where Id=" + id;
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

    @Override
    public List<Task> getAllTasks() {
        Connection connection = JdbcConfig.getConnection();
        String query = "Select * from Task";
        List<Task> tasks = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                task.setId(resultSet.getLong("Id"));
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
        Connection connection = JdbcConfig.getConnection();
        String query = "Select * from Task where ListId=" + listId;
        List<Task> listTasks = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                task.setId(resultSet.getLong("Id"));
                task.setCompleted(resultSet.getBoolean("Completed"));
                task.setDescription(resultSet.getString("Description"));
                task.setTitle(resultSet.getString("Title"));
                task.setListId(resultSet.getLong("ListId"));
                task.setUserId(resultSet.getString("UserId"));
                listTasks.add(task);
            }
            resultSet.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listTasks;
    }
}
