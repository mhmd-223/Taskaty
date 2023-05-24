package command.commands;

import java.util.List;

public class EditingListCommand extends Command{


    public EditingListCommand() {
        super(1, true);
    }

    @Override
    public boolean execute(List<String> args) {
        // TODO: edit list details
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
