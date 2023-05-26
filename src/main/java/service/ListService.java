package service;

import entity.TaskList;
import repository.ListRepository;

import java.util.List;

public class ListService {
    private final ListRepository repository;

    public ListService(ListRepository repository) {
        this.repository = repository;
    }

    public boolean addList(TaskList list) {
        try {
            repository.createTaskList(list);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean editListInfo(TaskList list) {
        try {
            repository.updateTaskList(list);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public List<TaskList> getLists(String username) {
        try {
            return repository.getListsByUsername(username);
        } catch (RuntimeException e) {
            return null;
        }
    }


    public boolean deleteList(Long listID) {
        try {
            repository.deleteTaskList(listID);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }


}
