package command.commands;

import java.util.List;

public class CreatingListCommand extends Command{

    public CreatingListCommand() {
        super(1, true);
    }
    @Override
    public boolean execute(List<String> args) {
        // TODO: create new list
        return true;
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
