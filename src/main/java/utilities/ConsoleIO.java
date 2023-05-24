package utilities;

import ui.ConsoleColors;

import java.io.Console;

public class ConsoleIO {
    private static final Console console = System.console();


    public static void printSuccessfulOperation(String msg) {
        console.printf(ConsoleColors.GREEN_BOLD + msg + ConsoleColors.RESET);
    }


    public static void printFailedOperation(String msg) {
        console.printf(ConsoleColors.RED_BOLD_BRIGHT + msg + ConsoleColors.RESET);
    }


    public static void printError(String err) {
        console.printf(ConsoleColors.RED_BOLD + err + ConsoleColors.RESET);
    }

    public static void printDocumentation(String doc) {
        console.printf(ConsoleColors.CYAN_BOLD + doc + ConsoleColors.RESET);
    }

    public static String readPassword(String prompt) {
        return String.valueOf(console.readPassword(prompt));
    }


    public static String readLine(String prompt) {
        return console.readLine(prompt);
    }
}
