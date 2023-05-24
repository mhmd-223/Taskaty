package command.commands;

import command.parsingandvalidation.Errors;
import entity.User;
import repository.mysql.MySQLDetailsRepo;
import repository.mysql.MySQLListRepo;
import repository.mysql.MySQLTaskRepo;
import repository.mysql.MySQLUserRepo;
import service.DetailService;
import service.ListService;
import service.TaskService;
import service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Command {

    private final int mandatoryArgsCount;
    private final boolean optionalArgsAllowed;
    protected TaskService taskService;
    protected ListService listService;
    protected DetailService detailService;
    protected UserService userService;
    private String errorMessage;

    public Command(int mandatoryArgsCount, boolean optionalArgsAllowed) {
        this.mandatoryArgsCount = mandatoryArgsCount;
        this.optionalArgsAllowed = optionalArgsAllowed;
        taskService = new TaskService(new MySQLTaskRepo());
        listService = new ListService(new MySQLListRepo());
        detailService = new DetailService(new MySQLDetailsRepo());
        userService = new UserService(new MySQLUserRepo());
    }

    public int getMandatoryArgsCount() {
        return mandatoryArgsCount;
    }

    public boolean isOptionalArgsAllowed() {
        return optionalArgsAllowed;
    }

    public abstract boolean execute(User user, List<String> args);

    public abstract String getDescription();

    public abstract String getUsage();

    public String getErrorMessage() {
        return errorMessage;
    }

    protected void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    protected Map<String, String> getArgsValues(List<String> args) {
        Map<String, String> argsValues = new HashMap<>();
        for (String arg : args) {
            if (arg.contains("=")) {
                String[] pair = arg.split("=");
                String key = pair[0], value = pair[1];
                if (!key.startsWith("desc") || !key.equals("title")) {
                    setErrorMessage(Errors.UNSUPPORTED_PROPERTY.formatted(key));
                    return null;
                }
                argsValues.put("desc", value.substring(1, value.length() - 1));
            } else argsValues.put("title", arg.substring(1, arg.length() - 1));
        }
        return argsValues;
    }

    protected <E> Integer validateId(List<String> args, List<E> tasks) {
        if (!args.get(0).chars().allMatch(Character::isDigit)) {
            setErrorMessage(Errors.INVALID_ID_FORMAT.formatted(args.get(0)));
            return null;
        }
        int id = Integer.parseInt(args.get(0));
        if (id >= tasks.size() || id < 0) {
            setErrorMessage(Errors.INVALID_ID_VALUE.formatted(id));
            return null;
        }
        return id;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public void setListService(ListService listService) {
        this.listService = listService;
    }

    public void setDetailService(DetailService detailService) {
        this.detailService = detailService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
