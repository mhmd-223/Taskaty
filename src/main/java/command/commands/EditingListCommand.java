package command.commands;

import command.parsingandvalidation.Errors;
import entity.Detail;
import entity.TaskList;
import entity.User;

import java.util.List;

public class EditingListCommand extends Command {


    public EditingListCommand() {
        super(1, true);
    }

    @Override
    public boolean execute(User user, List<String> args) {
        List<TaskList> lists = user.getTaskLists();
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
            detail = new Detail(pair[0], pair[1], lists.get(id).getId());
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
                This command allows users to edit the details of an existing list.
                Users need to specify the name of the list they want to modify and provide
                the updated detail along with its value.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:   editdetail "<ListName>" <detail="value">
                Example: editdetail "Work Projects" detail="New details"
                """;
    }
}
