package command.commands;

import entity.TaskList;
import service.Session;
import ui.ListPage;

import java.util.List;

public class ShowingTasksCommand extends Command {

    public ShowingTasksCommand() {
        super(1, false);
    }

    @Override
    public boolean execute(Session session, List<String> args) {
        List<TaskList> lists = session.getUser().getTaskLists();
        Integer listID = validateId(args, lists);
        if (listID == null)
            return false;
        session.setPage(new ListPage(listID, session.getUser()));
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
