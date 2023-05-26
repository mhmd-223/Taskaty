package utilities;

import ui.ConsoleColors;

import java.io.Console;

public class ConsoleIO {
    private static final Console console = System.console();


    public static void printSuccessfulOperation(String msg) {
        consolePrint(ConsoleColors.GREEN_BOLD + msg + ConsoleColors.RESET);
    }


    public static void printFailedOperation(String msg) {
        consolePrint(ConsoleColors.RED_BOLD_BRIGHT + msg + ConsoleColors.RESET);
    }


    public static void printError(String err) {
        consolePrint(ConsoleColors.RED_BOLD + err + ConsoleColors.RESET);
    }

    public static void printDocumentation(String doc) {
        consolePrint(ConsoleColors.CYAN_BOLD + doc + ConsoleColors.RESET);
    }

    public static String readPassword(String prompt) {
        return scannerRead(prompt);
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

    private static void print(String s) {
        System.out.println(s);
    }

    private static void consolePrint(String s) {
        console.printf(s + System.lineSeparator());
    }

    private static String scannerRead(String prompt) {
        return new EasyScanner().readSentence(prompt).trim();
    }

    private static String consoleRead(String prompt) {
        return console.readLine(prompt);
    }
}
