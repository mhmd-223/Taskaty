package utilities;

import ui.ConsoleColors;

import java.io.Console;

public class ConsoleIO {
    private static final Console console = System.console();


    public static void printSuccessfulOperation(String msg) {
        print(ConsoleColors.GREEN_BOLD + msg + ConsoleColors.RESET);
    }


    public static void printFailedOperation(String msg) {
        print(ConsoleColors.RED_BOLD_BRIGHT + msg + ConsoleColors.RESET);
    }


    public static void printError(String err) {
        print(ConsoleColors.RED_BOLD + err + ConsoleColors.RESET);
    }

    public static void printDocumentation(String doc) {
        print(ConsoleColors.CYAN_BOLD + doc + ConsoleColors.RESET);
    }

    public static String readPassword(String prompt) {
        return scannerRead(prompt);
    }

    public static String readSecuredPassword(String prompt) {
        return String.valueOf(console.readPassword(prompt)).trim();
    }


    public static String readLine(String prompt) {
        return scannerRead(prompt);
    }

    private static void print(String s) {
        System.out.println(s);
    }

    private static void consolePrint(String s) {
        console.printf(s);
    }

    private static String scannerRead(String prompt) {
        return new EasyScanner().readSentence(prompt).trim();
    }
}
