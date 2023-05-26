package command.commands;

import command.parsingandvalidation.Errors;
import repository.mysql.MySQLDetailsRepo;
import repository.mysql.MySQLListRepo;
import repository.mysql.MySQLTaskRepo;
import repository.mysql.MySQLUserRepo;
import service.*;

import java.util.List;

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

    public abstract boolean execute(Session session, List<String> args);

    public abstract String getDescription();

    public abstract String getUsage();

    public String getErrorMessage() {
        return errorMessage;
    }

    protected void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    protected <E> Integer validateId(List<String> args, List<E> tasks) {
        if (!args.get(0).chars().allMatch(Character::isDigit)) {
            setErrorMessage(Errors.INVALID_ID_FORMAT.formatted(args.get(0)));
            return null;
        }
        int id = Integer.parseInt(args.get(0));
        if (id > tasks.size() || id <= 0) {
            setErrorMessage(Errors.INVALID_ID_VALUE.formatted(id));
            return null;
        }
        return id - 1;
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

    protected String removeQuotes(String quoted) {
        if (!quoted.contains("\""))
            return quoted;
        return quoted.substring(1, quoted.length() - 1);
    }
}
