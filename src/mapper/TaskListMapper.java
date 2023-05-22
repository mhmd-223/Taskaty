package mapper;

import entity.Task;
import entity.TaskList;
import repository.JdbcConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;

public class TaskListMapper implements TaskListMapperInterface {
    private TaskList taskList;

    @Override
    public TaskList getList(Long id) {
        Connection connection = JdbcConfig.getConnection();
        String query = "Select * from List where Id=" + id+";";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            TaskMapper taskMapper = new TaskMapper();
            DetailsMapper detailsMapper = new DetailsMapper();
            if (resultSet.next()) {
                taskList.setId(resultSet.getLong("Id"));
                taskList.setTitle(resultSet.getString("Title"));
                taskList.setTasks(taskMapper.getTasksOfList(resultSet.getLong("Id")));
                taskList.setDetails(detailsMapper.getDetailsOfList(resultSet.getLong("Id")));
            }
            resultSet.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return taskList;
    }
}
