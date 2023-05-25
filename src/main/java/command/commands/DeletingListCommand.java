package command.commands;

import entity.TaskList;
import entity.User;
import ui.ConsoleColors;

import java.util.List;

public class DeletingListCommand extends Command {

    public DeletingListCommand() {
        super(1, false);
    }

    @Override
    public boolean execute(User user, List<String> args) {
        List<TaskList> lists = user.getTaskLists();
        Integer ordinal = validateId(args, lists);
        if (ordinal == null)
            return false;
        boolean deletionResult = listService.deleteList(lists.get(ordinal).getId());
        if (deletionResult)
            return true;
        setErrorMessage("Failed to delete " + lists.get(ordinal).getTitle() + " list.");
        return true;

    }

    @Override
    public String getDescription() {
        return """
                deletelist:  This command deletes an existing task list.
                             Users need to specify the ordinal of the list as they appear on HOMEPAGE,
                             and the system will permanently remove it along with all the tasks it contains.
                """;
    }

    @Override
    public String getUsage() {
        return """  
                Usage:   deletelist <listOrdinal>
                Example: deletelist 1
                """;
    }
}
