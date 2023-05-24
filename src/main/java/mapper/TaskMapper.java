package mapper;

import entity.Task;
import repository.MySQLConfigure;
import utilities.QueryBuilder;

import java.sql.*;
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
                task.setId(resultSet.getLong("id"));
                task.setCompleted(resultSet.getBoolean("iscompleted"));
                task.setDescription(resultSet.getString("description_"));
                task.setTitle(resultSet.getString("title"));
                task.setListId(resultSet.getLong("listid"));
                task.setUserId(resultSet.getString("username"));
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
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task task1 = new Task();
                task1.setId(resultSet.getLong("id"));
                task1.setCompleted(resultSet.getBoolean("iscompleted"));
                task1.setDescription(resultSet.getString("description_"));
                task1.setTitle(resultSet.getString("title"));
                task1.setListId(resultSet.getLong("listid"));
                task1.setUserId(resultSet.getString("username"));
                tasks.add(task1);
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
