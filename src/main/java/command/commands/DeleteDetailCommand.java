package command.commands;

import entity.Detail;
import entity.TaskList;
import entity.User;
import service.Session;

import java.util.List;

public class DeleteDetailCommand extends Command {

    public DeleteDetailCommand() {
        super(2, false);
    }

    @Override
    public boolean execute(Session session, List<String> args) {
        User user = session.getUser();
        Integer listOrdinal = validateId(args, user.getTaskLists());
        if (listOrdinal == null) return false;
        TaskList list = user.getTaskLists().get(listOrdinal);
        List<Detail> details = list.getDetails();
        Long detailID = null;
        for (Detail detail : details) {
            if (detail.getKey().equals(args.get(1)))
                detailID = detail.getId();
        }
        if (detailID == null) {
            setErrorMessage("No detail called: " + args.get(1));
            return false;
        }
        boolean result = detailService.deleteDetail(detailID);
        if (result)
            return true;
        setErrorMessage("Failed to delete detail.");
        return false;
    }

    @Override
    public String getDescription() {
        return """
                deletedetail:  This command will delete a detail of a list.
                               Users should provide a list position, in addition to the detail title.
                """;
    }

    @Override
    public String getUsage() {
        return """
                Usage:    deletedetail <listPosition> <detailTitle>
                Example:  deletedetail 1 detail
                """;
    }
}
