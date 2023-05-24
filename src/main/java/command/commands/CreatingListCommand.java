package command.commands;

import command.parsingandvalidation.Errors;
import entity.Detail;
import entity.TaskList;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class CreatingListCommand extends Command {

    public CreatingListCommand() {
        super(1, true);
    }

    @Override
    public boolean execute(User user, List<String> args) {
        String listTitle = args.remove(0);
        if (listTitle.contains("=")) {
            setErrorMessage(Errors.INVALID_LIST_NAME.formatted(listTitle));
            return false;
        }
        // Todo HOW TO ADD LIST ID TO EACH DETAIL
        List<Detail> details = new ArrayList<>();
        if (!args.isEmpty()) {
            for (String arg : args) {
                if (!arg.contains("=")) {
                    setErrorMessage(Errors.MISSING_PROPERTY_NAME.formatted(arg));
                    return false;
                }
                String[] pair = arg.split("=");
                Detail detail = new Detail(pair[0], pair[1], null);
                details.add(detail);
            }
        }
        TaskList list = new TaskList(null, listTitle, user.getUsername(), null, details);
        boolean creationResult = listService.addList(list);
        if (creationResult)
            return true;
        setErrorMessage("Failed to create a list.");
        return false;
    }

    @Override
    public String getDescription() {
        return """
                This command enables users to create a new task list.
                Users need to provide a title for the list, and they can optionally
                include additional details or descriptions for the list.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   newlist "<Title>" [detail="Details"] [...]
                Example: newlist "Work Projects" detail="Important projects for Q2"
                """;
    }
}
