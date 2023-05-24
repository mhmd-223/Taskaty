package command.commands;

import java.util.List;

public class DeletingListCommand extends Command{

    public DeletingListCommand() {
        super(1, false);
    }

    @Override
    public boolean execute(List<String> args) {
        // TODO: delete list
        return true;

    }

    @Override
    public String getDescription() {
        return """
                This command deletes an existing task list.
                Users need to specify the name of the list they want to delete,
                and the system will permanently remove it along with all the tasks it contains.
                """;
    }

    @Override
    public String getUsage() {
        return """  
                Usage:   deletelist "<listName>"
                Example: deletelist "Personal"
                """;
    }
}
