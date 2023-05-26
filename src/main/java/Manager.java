import command.commands.*;
import command.execution.CommandExecutor;
import command.execution.CommandHandler;
import command.execution.ExecutionResult;
import command.parsingandvalidation.Errors;
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
    private final Session session;
    Page page = new LaunchingPage();
    private User user;

    public Manager() {
        user = new User();
        session = new Session();
        handler = new CommandHandler();
        page.refresh();
        String input = page.prompt();
        Command command = handler.parseAndValidate(input);
        command = getStartingCommands(input, command);

        if (command instanceof CreatingAccountCommand) {
            readPassword(command);
            runSession();
        }

        if (command instanceof LoginCommand) {
            login(command);
        }
    }

    private void login(Command command) {
        readPassword(command);
        /* Successful login */
        runSession();
    }

    private Command getStartingCommands(String input, Command command) {
        while (!(command instanceof CreatingAccountCommand) && !(command instanceof LoginCommand)) {
            if (command == null && input.contains("login") || input.startsWith("new"))
                ConsoleIO.printError(handler.getErrorMessage());
            else
                ConsoleIO.printError("You are not logged in. You cannot perform any other commands.");
            input = page.prompt();
            command = handler.parseAndValidate(input);
        }
        return command;
    }

    private void readPassword(Command command) {
        String pass = ConsoleIO.readSecuredPassword("Password >> ");
        user.setPassword(pass);
        session.setUser(user);
        ExecutionResult result = CommandExecutor.executeCommand(command, handler.getArgs(), session);
        while (!result.isSuccess()) {
            ConsoleIO.printError(result.getErrorMessage());
            if (result.getErrorMessage().equals(Errors.WRONG_PASSWORD)) {
                pass = ConsoleIO.readSecuredPassword("Password >> ");
                user.setPassword(pass);
            } else {
                String input = page.prompt();
                command = getStartingCommands(input, handler.parseAndValidate(input));
                login(command);
            }
            result = CommandExecutor.executeCommand(command, handler.getArgs(), session);
        }
    }

    private void runSession() {
        session.start();
        session.getPage().refresh();
        while (session.isLoggedIn()) {
            String commandInput = page.prompt();
            Command handledCommand = handler.parseAndValidate(commandInput);
            if (handledCommand == null) {
                ConsoleIO.printError(handler.getErrorMessage());
                continue;
            }
            if (handledCommand instanceof LoggingOutCommand) {
                session.end();
                App.main(null);
            }
            if (handledCommand instanceof CreatingAccountCommand || handledCommand instanceof LoginCommand) {
                ConsoleIO.printError("You must logout to perform this command.");
                continue;
            }
            ExecutionResult executionResult = CommandExecutor.executeCommand(handledCommand, handler.getArgs(), session);
            if (!executionResult.isSuccess()) {
                ConsoleIO.printError(executionResult.getErrorMessage());
                continue;
            }
            session.refreshUser();
            session.getPage().updateContent(session.getUser());
            if (!(handledCommand instanceof HelpCommand))
                session.getPage().refresh();
            ConsoleIO.printSuccessfulOperation("Successful Operation");
        }
    }

}
