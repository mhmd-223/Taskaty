package repository.mysql;

import entity.Task;
import mapper.TaskMapper;
import repository.MySQLConfigure;
import repository.TaskRepository;
import utilities.QueryBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySQLTaskRepo implements TaskRepository {

    @Override
    public void createTask(Task task) throws RuntimeException {
        String taskValues = "null" + ",'" + task.getUserId() + "'," + task.getListId() + ",'" + task.getTitle() + "','" + task.getDescription() + "'," + task.isCompleted();
        String createQuery = new QueryBuilder().insert("task", taskValues).build();
        MySQLConfigure.accessDatabase(MySQLConfigure.getConnection(), createQuery);
    }

    @Override
    public void updateTask(Task task) throws RuntimeException {
        Map<String, String> attributes = new HashMap<>();
        attributes.put("id", Long.toString(task.getId()));
        attributes.put("username", "'" + task.getUserId() + "'");
        attributes.put("listid", task.getListId() == 0 ? "NULL" : Long.toString(task.getListId()));
        attributes.put("title", "'" + task.getTitle() + "'");
        attributes.put("description_", "'" + task.getDescription() + "'");
        attributes.put("iscompleted", task.isCompleted() ? "1" : "0");
        String updateQuery = new QueryBuilder()
                .update("task")
                .set(attributes)
                .where("id=" + task.getId())
                .build();
        MySQLConfigure.accessDatabase(MySQLConfigure.getConnection(), updateQuery);

    }

    @Override
    public void deleteTask(Long taskId) throws RuntimeException {
        String deleteQuery = new QueryBuilder()
                .delete("task")
                .where("id=" + taskId)
                .build();
        MySQLConfigure.accessDatabase(MySQLConfigure.getConnection(), deleteQuery);
    }

    @Override
    public List<Task> getTasksByListID(Long listId) throws RuntimeException {
        String query = new QueryBuilder()
                .select("*")
                .from("task")
                .where("listid=" + listId)
                .build();

        return new TaskMapper().getTasks(MySQLConfigure.getConnection(), query);
    }

    @Override
    public List<Task> getTasksByUserID(String userId) throws RuntimeException {
        String query = new QueryBuilder()
                .select("*")
                .from("task")
                .where("username=" + "'" + userId + "'")
                .build();
        return new TaskMapper().getTasks(MySQLConfigure.getConnection(), query);
    }

    @Override
    public boolean existsById(Long id) throws RuntimeException {
        String query =
                new QueryBuilder()
                        .select("*")
                        .from("task")
                        .where("id=" + id)
                        .build();
        return (new TaskMapper().getTask(MySQLConfigure.getConnection(), query).getId() != null);
    }
}
