package command.commands;

import entity.TaskList;
import entity.User;
import ui.ListPage;
import ui.Page;

import java.util.List;

public class ShowingTasksCommand extends Command {

    public ShowingTasksCommand() {
        super(1, false);
    }

    @Override
    public boolean execute(User user, List<String> args) {
        List<TaskList> lists = user.getTaskLists();
        Integer listID = validateId(args, lists);
        if (listID == null)
            return false;
        Page listPage = new ListPage(lists.get(listID));
        listPage.refresh();
        return true;

    }

    @Override
    public String getDescription() {
        return """
                showtasks:  This command displays all the tasks in a specific list.
                            Users need to provide the ordinal of the list they want to view,
                            and the command will present the tasks along with their IDs, titles, and other details.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   showtasks <ListOrdinal>
                Example: showtasks 1
                """;
    }
}
