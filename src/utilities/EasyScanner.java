package utilities;

import java.util.Scanner;

/**
 * The EasyScanner class provides simplified input methods for reading various data types from the console.
 * It wraps the standard Scanner class and provides additional error handling and input validation.
 */

public class EasyScanner {
    private final Scanner scanner;

    /**
     * Constructs an EasyScanner object that uses the standard input as the input source.
     */
    public EasyScanner() {
        scanner = new Scanner(System.in);
    }

    /**
     * Reads an integer value from the console.
     *
     * @return The integer value entered by the user.
     */
    public int readInt() {
        return readValidInt("", "");
    }

    /**
     * Reads an integer value from the console with a prompt message.
     *
     * @param promptMessage The message displayed to prompt the user for input.
     * @return The integer value entered by the user.
     */
    public int readInt(String promptMessage) {
        return readValidInt(promptMessage, "");
    }

    /**
     * Reads an integer value from the console with a prompt message and an error message.
     * If the input is invalid, the error message is displayed and the user is prompted again.
     *
     * @param promptMessage The message displayed to prompt the user for input.
     * @param errorMessage  The error message displayed when the input is invalid.
     * @return The integer value entered by the user.
     */
    public int readInt(String promptMessage, String errorMessage) {
        return readValidInt(promptMessage, errorMessage);
    }

    /**
     * Reads a double value from the console.
     *
     * @return The double value entered by the user.
     */
    public double readDouble() {
        return readValidDouble("", "");
    }

    /**
     * Reads a double value from the console with a prompt message.
     *
     * @param promptMessage The message displayed to prompt the user for input.
     * @return The double value entered by the user.
     */
    public double readDouble(String promptMessage) {
        return readValidDouble(promptMessage, "");
    }

    /**
     * Reads a double value from the console with a prompt message and an error message.
     * If the input is invalid, the error message is displayed and the user is prompted again.
     *
     * @param promptMessage The message displayed to prompt the user for input.
     * @param errorMessage  The error message displayed when the input is invalid.
     * @return The double value entered by the user.
     */
    public double readDouble(String promptMessage, String errorMessage) {
        return readValidDouble(promptMessage, errorMessage);
    }

    /**
     * Reads a single word (string without spaces) from the console.
     *
     * @return The word entered by the user.
     */
    public String readWord() {
        return scanner.next();
    }

    /**
     * Reads a single word (string without spaces) from the console with a prompt message.
     *
     * @param promptMessage The message displayed to prompt the user for input.
     * @return The word entered by the user.
     */
    public String readWord(String promptMessage) {
        print(promptMessage);
        return readWord();
    }

    /**
     * Reads a sentence (string with spaces) from the console.
     *
     * @return The sentence entered by the user.
     */
    public String readSentence() {
        return scanner.nextLine();
    }

    /**
     * Reads a sentence (string with spaces) from the console with a prompt message.
     *
     * @param promptMessage The message displayed to prompt the user for input.
     * @return The sentence entered by the user.
     */
    public String readSentence(String promptMessage) {
        print(promptMessage);
        return

                readSentence();
    }

    /**
     * Reads a single character from the console.
     *
     * @return The character entered by the user.
     */
    public char readChar() {
        return readWord().charAt(0);
    }

    /**
     * Reads a single character from the console with a prompt message.
     *
     * @param promptMessage The message displayed to prompt the user for input.
     * @return The character entered by the user.
     */
    public char readChar(String promptMessage) {
        print(promptMessage);
        return readWord().charAt(0);
    }

    /**
     * Displays a menu with the provided options and reads the user's choice.
     * The user is prompted until a valid choice is entered.
     *
     * @param menu An array of menu options.
     * @return The index of the chosen option.
     */
    public int selectFromMenu(String[] menu) {
        final StringBuilder sb = new StringBuilder();
        print("Choose from this list:\n");
        for (int i = 0; i < menu.length; i++) {
            sb.append("\t\t\t\t\t  ").append(i + 1).append(". ").append(menu[i]).append("\n");
        }
        print(sb.toString());
        int choiceIndex;
        while (true) {
            String choice = readSentence("Choice: ");
            try {
                choiceIndex = Integer.parseInt(choice) - 1;
                try {
                    choice = menu[choiceIndex]; // validate the chosen index.
                    break;
                } catch (IndexOutOfBoundsException e) {
                    print("Choice must be in range of (%d, %d)".formatted(1, menu.length) + "\n");
                }
            } catch (NumberFormatException e) {
                if ((choiceIndex = isInMenu(menu, choice)) >= 0) {
                    return choiceIndex;
                }
                print("Provided choice is not in the menu.\n");
            }
        }
        return choiceIndex;
    }

    private int isInMenu(String[] menu, String choice) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].equalsIgnoreCase(choice)) {
                return i;
            }
        }
        return -1; // not in the menu
    }

    private void print(String message) {
        System.out.print(message);
    }

    private int readValidInt(String prompt, String error) {
        print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            print(error + "\n");
            print(prompt);
        }
        return scanner.nextInt();
    }

    private double readValidDouble(String prompt, String error) {
        print(prompt);
        while (!scanner.hasNextDouble()) {
            scanner.next();
            print(error);
            print(prompt);
        }
        return scanner.nextDouble();
    }
}
