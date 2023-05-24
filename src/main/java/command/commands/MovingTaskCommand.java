package command.commands;

import java.util.List;

public class MovingTaskCommand extends Command{

    public MovingTaskCommand() {
        super(2, false);
    }

    @Override
    public boolean execute(List<String> args) {
        // TODO: Moving task execution
        return true;

    }

    @Override
    public String getDescription() {
        return """
                With this command, users can move a specific task from one list to another.
                Users need to provide the ID of the task they want to move and specify the name of the destination list.
                """;
    }

    @Override
    public String getUsage() {
        return """  
                Usage:   move <TaskID> "<ListName>"
                Example: move 1 "In Progress"
                """;
    }
}
