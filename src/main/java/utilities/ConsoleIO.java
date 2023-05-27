package utilities;

import ui.ConsoleColors;

import java.io.Console;

public class ConsoleIO {
    private static final Console console = System.console();


    public static void printSuccessfulOperation(String msg) {
        consolePrint(ConsoleColors.GREEN_BOLD + msg + ConsoleColors.RESET);
    }


    public static void printError(String err) {
        consolePrint(ConsoleColors.RED_BOLD + err + ConsoleColors.RESET);
    }

    public static void printDocumentation(String doc) {
        consolePrint(ConsoleColors.CYAN_BOLD + doc + ConsoleColors.RESET);
    }

    public static String readSecuredPassword(String prompt) {
        return String.valueOf(console.readPassword(prompt)).trim();
    }

    public static String readLine(String prompt) {

        String read = null;

        while (read == null || read.isEmpty() || read.isBlank())
            read = consoleRead(prompt);

        return read;
    }


    private static void consolePrint(String s) {
        console.printf(s + System.lineSeparator());
    }


    private static String consoleRead(String prompt) {
        return console.readLine(prompt);
    }
}
