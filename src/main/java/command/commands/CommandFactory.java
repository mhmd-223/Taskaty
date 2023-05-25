package command.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final Map<String, Class<? extends Command>> commands = new HashMap<>();

    static {
        commands.put("addtask", AddingTaskCommand.class);
        commands.put("edittask", EditingTaskCommand.class);
        commands.put("move", MovingTaskCommand.class);
        commands.put("showtasks", ShowingTasksCommand.class);
        commands.put("complete", MarkingCompletedCommand.class);
        commands.put("open", OpeningTaskCommand.class);
        commands.put("deletetask", DeletingTaskCommand.class);
        commands.put("newlist", CreatingListCommand.class);
        commands.put("editdetail", EditingListCommand.class);
        commands.put("deletelist", DeletingListCommand.class);
        commands.put("login", LoginCommand.class);
        commands.put("newuser", CreatingAccountCommand.class);
        commands.put("logout", LoggingOutCommand.class);
        commands.put("home", HomepageCommand.class);
        commands.put("exit", ExitingCommand.class);
        commands.put("help", HelpCommand.class);
    }

    public static Command createCommand(String tag) {
        Class<? extends Command> commandClass = commands.get(tag);
        try {
            return commandClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    public static Map<String, Class<? extends Command>> getCommands() {
        return commands;
    }
}
