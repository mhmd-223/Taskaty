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
        String taskValues = task.getUserId()+","+task.getListId() + "," +task.getTitle()+ "," + task.getDescription();
        String createQuery = new QueryBuilder().insert("task", taskValues).build();
        MySQLConfigure.accessDatabase(MySQLConfigure.getConnection(),createQuery);
    }

    @Override
    public void updateTask(Task task) throws RuntimeException {
        Map<String, String> attributes = new HashMap<>();
        //attributes.put("id",Long.toString(task.getId()));
        attributes.put("username", task.getUserId());
        attributes.put("listid", Long.toString(task.getListId()));
        attributes.put("title", task.getTitle());
        attributes.put("description", task.getDescription());
        String updateQuery = new QueryBuilder()
                            .update("task")
                            .set(attributes)
                            .where("id=" +task.getId())
                            .build();
        MySQLConfigure.accessDatabase(MySQLConfigure.getConnection(),updateQuery);

    }

    @Override
    public void deleteTask(Task task) throws RuntimeException {
        String deleteQuery = new QueryBuilder()
                .delete("task")
                .where("id=" + task.getId())
                .build();
        MySQLConfigure.accessDatabase(MySQLConfigure.getConnection(),deleteQuery);
    }

    @Override
    public List<Task> getTasksByListID(Long listId) throws RuntimeException {

        String query = new QueryBuilder()
                .select("*")
                .from("task")
                .where("listid" + listId)
                .build();

        return new TaskMapper().getTasks(MySQLConfigure.getConnection(),query);
    }

    @Override
    public List<Task> getTasksByUserID(String userId) throws RuntimeException {
        String query = new QueryBuilder()
                .select("*")
                .from("task")
                .where("userid" + userId)
                .build();
        return new TaskMapper().getTasks(MySQLConfigure.getConnection(),query) ;
    }

    @Override
    public boolean existsById(Long id) throws RuntimeException {
        String query =
                new QueryBuilder()
                        .select("*")
                        .from("task")
                        .where("id=" +id)
                        .build();
        return (new TaskMapper().getTask(MySQLConfigure.getConnection(),query)!=null);
    }
}
