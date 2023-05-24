import command.commands.Command;
import command.commands.CreatingAccountCommand;
import command.commands.LoggingOutCommand;
import command.commands.LoginCommand;
import command.execution.CommandExecutor;
import command.execution.CommandHandler;
import command.execution.ExecutionResult;
import entity.User;
import service.Session;
import ui.LaunchingPage;
import ui.Page;
import utilities.ConsoleIO;

/**
 * This class will control all the application operations
 * delegating each operation to the corresponding class
 */
public class Manager {
    private final CommandHandler handler;
    private User user;

    public Manager() {
        user = new User();
        handler = new CommandHandler();
        Page page = new LaunchingPage();
        page.refresh();
        String input = page.prompt();
        Command command = handler.parseAndValidate(input);
        while (!(command instanceof CreatingAccountCommand) && !(command instanceof LoginCommand)) {
            if (command == null && input.contains("login") || input.contains("newuser"))
                ConsoleIO.printError(handler.getErrorMessage());
            else
                ConsoleIO.printError("You are not logged in. You cannot perform any other commands.");
            input = page.prompt();
            command = handler.parseAndValidate(input);
        }

        register(command);

        if (command instanceof LoginCommand) {
            readPassword(command);
            user = ((LoginCommand) command).getSuccessfulLoggedUser();
            /* Successful login */
            runSession();
        }
    }

    private void readPassword(Command command) {
        String pass = ConsoleIO.readPassword("Password >> ");
        user.setPassword(pass);
        ExecutionResult result = CommandExecutor.executeCommand(command, handler.getArgs(), user);
        while (!result.isSuccess()) {
            ConsoleIO.printError(result.getErrorMessage());
            pass = ConsoleIO.readPassword("Password >> ");
            user.setPassword(pass);
            result = CommandExecutor.executeCommand(command, handler.getArgs(), user);
        }
    }

    private void runSession() {
        Session session = new Session(user);
        session.start();
        while (session.isLoggedIn()) {
            String commandInput = ConsoleIO.readLine(">> ");
            Command handledCommand = handler.parseAndValidate(commandInput);
            if (handledCommand == null) {
                ConsoleIO.printError(handler.getErrorMessage());
                continue;
            }
            if (handledCommand instanceof LoggingOutCommand) {
                session.end();
                App.main(null);
            }
            ExecutionResult executionResult = CommandExecutor.executeCommand(handledCommand, handler.getArgs(), session.getUser());
            if (!executionResult.isSuccess()) {
                ConsoleIO.printError(executionResult.getErrorMessage());
                continue;
            }
            ConsoleIO.printSuccessfulOperation("successful");
            session.refreshUser();
        }
    }

    private void register(Command command) {
        if (command instanceof CreatingAccountCommand) {
            readPassword(command);
        }
    }
}
