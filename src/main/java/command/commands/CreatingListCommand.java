package command.commands;

import command.parsingandvalidation.Errors;
import entity.TaskList;
import service.Session;
import utilities.StringUtils;

import java.util.List;

public class CreatingListCommand extends Command {

    public CreatingListCommand() {
        super(1, false);
    }

    @Override
    public boolean execute(Session session, List<String> args) {
        String listTitle = StringUtils.removeQuotes(args.remove(0));
        if (listTitle.contains("=")) {
            setErrorMessage(Errors.INVALID_LIST_NAME.formatted(listTitle));
            return false;
        }

        TaskList list = new TaskList(null, listTitle, session.getUser().getUsername(), null, null);
        boolean creationResult = listService.addList(list);
        if (creationResult)
            return true;
        setErrorMessage("Failed to create a list.");
        return false;
    }

    @Override
    public String getDescription() {
        return """
                newlist:  This command enables users to create a new task list.
                          Users need to provide a title for the list.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   newlist "<Title>"
                Example: newlist "Work Projects"
                """;
    }
}
