package command.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final Map<String, Class<? extends Command>> commands = new HashMap<>();

    static {
        commands.put("addtask", AddingTaskCommand.class);
        commands.put("edittask", EditingListCommand.class);
        // TODO: write the rest of commands
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
}
