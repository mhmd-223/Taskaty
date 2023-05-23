package repository.mysql;

import entity.TaskList;
import mapper.TaskListMapper;
import repository.ListRepository;
import repository.MySQLConfigure;
import utilities.QueryBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySQLListRepo implements ListRepository {
    @Override
    public void createTaskList(TaskList taskList) throws RuntimeException {
        String taskValues = taskList.getTitle();
        String createQuery = new QueryBuilder().insert("tasklist", taskValues).build();
        MySQLConfigure.accessDatabase(MySQLConfigure.getConnection(),createQuery);
    }

    @Override
    public void updateTaskList(TaskList taskList) throws RuntimeException {
        Map<String, String> attributes = new HashMap<>();
        //_____________________________________
        //  TODO:CHANGE ID FROM STRING TO LONG
        //attributes.put("id",Long.toString(taskList.getId()));
        //_____________________________________
        attributes.put("title", taskList.getTitle());
        String updateQuery = new QueryBuilder()
                .update("tasklist")
                .set(attributes)
                .where("id=" +taskList.getId())
                .build();
        MySQLConfigure.accessDatabase(MySQLConfigure.getConnection(),updateQuery);
    }

    @Override
    public void deleteTaskList(Long taskListId) throws RuntimeException {
        String deleteQuery = new QueryBuilder()
                .delete("tasklist")
                .where("id=" + taskListId)
                .build();
        MySQLConfigure.accessDatabase(MySQLConfigure.getConnection(),deleteQuery);
    }

    @Override
    public List<TaskList> getListsByUserId(String userId) throws RuntimeException {
       // String query = "Select * from List where Id=" + id + ";";
        String query= new QueryBuilder().select("*").from("tasklist").where("id="+userId).build();
        List<TaskList> taskLists=new TaskListMapper().getLists(MySQLConfigure.getConnection(),query);
        MySQLDetailsRepo details= new MySQLDetailsRepo();
        MySQLTaskRepo task= new MySQLTaskRepo();
        for (TaskList list: taskLists) {
            list.setDetails(details.getDetailsByListId(list.getId()));
            list.setTasks(task.getTasksByListID(list.getId()));
        }

        return taskLists;
    }

    @Override
    public boolean existsById(Long id) throws RuntimeException {
        String query= new QueryBuilder().select("*").from("tasklist").where("id="+id).build();
        return (new TaskListMapper().getList(MySQLConfigure.getConnection(),query).getId()!=null);
    }
}
