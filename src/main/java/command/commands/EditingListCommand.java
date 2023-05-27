package command.commands;

import command.parsingandvalidation.Errors;
import entity.Detail;
import entity.TaskList;
import service.Session;
import utilities.StringUtils;

import java.util.List;

public class EditingListCommand extends Command {


    public EditingListCommand() {
        super(1, true);
    }

    @Override
    public boolean execute(Session session, List<String> args) {
        List<TaskList> lists = session.getUser().getTaskLists();
        Integer id = validateId(args, lists);
        if (id == null)
            return false;
        args.remove(0);
        Detail detail;
        for (String arg : args) {
            if (!arg.contains("=")) {
                setErrorMessage(Errors.MISSING_PROPERTY_NAME.formatted(arg));
                return false;
            }
            String[] pair = arg.split("=");
            detail = new Detail(pair[0], StringUtils.removeQuotes(pair[1]), lists.get(id).getId());
            boolean updatingResult = detailService.updateDetail(detail, lists.get(id).getId());
            if (updatingResult)
                return true;
            setErrorMessage("Failed to edit details for the list " + lists.get(id).getTitle());
        }


        return true;

    }

    @Override
    public String getDescription() {
        return """
                editdetail:  This command allows users to edit the details of an existing list, if this detail does not exist, a new detail will be created.
                             Users need to specify the ordinal of the list on HOMEPAGE they want to modify
                             and provide the updated detail along with its value.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   editdetail <listOrdinal> <detail="value">
                Example: editdetail 1 detail="New details"
                """;
    }
}
