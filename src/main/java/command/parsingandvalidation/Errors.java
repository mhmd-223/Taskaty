package command.parsingandvalidation;

public class Errors {
    public static final String UNSUPPORTED_COMMAND = """
            Unsupported command: The command '%s' is not recognized.
            Please check your spelling and try again.
            """;
    public static final String MISSING_VALUE_ASSIGNMENT = """
            Missing value for property: The assignment of property in '%s' is missing a value.
            Please provide a valid value for the property.
            """;
    public static final String MISSING_PROPERTY_NAME = """
            Missing property name: The assignment of property in '%s' is missing a name.
            Please specify a valid property name.
            """;
    public static final String UNQUOTED_VALUE = """
            Unquoted value: The value for '%s' property must be enclosed in quotes.
            Please provide the value within double quotes.
            """;
    public static final String UNCLOSED_QUOTE = """
            Unclosed quote in argument: %s
            Please make sure to provide a closing quote for the argument.
            """;
    public static final String MISSING_OPENING_QUOTE = """
            Missing opening quote in argument: %s.
            Please make sure to provide an opening quote for the argument.
            """;

    public static final String NO_ARGUMENTS_ALLOWED = """
            No Arguments Expected: '%s' command does not require any arguments.
            Please remove any arguments from your command input.
            """;
    public static final String NO_OPTIONAL_ARGUMENTS = """
            Optional Arguments Not Allowed: '%s' command does not support any optional arguments.
            Please provide only the required arguments and remove any optional arguments from your command input.
            """;
    public static final String INVALID_ARGUMENTS_COUNT = """
            Invalid Arguments Count: '%s' command expects %s arguments, but %s are provided.
            Please provide the correct number of arguments as specified in the command documentation.
            """;
    public static final String UNSUPPORTED_PROPERTY = """
            Unsupported Task Property: The task property '%s' is not supported.
            Please make sure you are using valid properties for the task.
                        
            Supported properties: title, description
            """;
    public static final String INVALID_ID_FORMAT = """
            Invalid Task ID: The provided ID '%s' for the task is not valid.
            Please make sure to provide a numeric ID for the task.
            """;
    public static final String INVALID_ID_VALUE = """
            Invalid Task ID: The provided task ID '%s' is not valid.
            Please make sure to enter a numeric ID corresponding to an existing task.
            """;

    public static final String INVALID_LIST_NAME = """
            Invalid List Name: The provided list name '%s' is not valid.
            Please make sure to enter a valid list name.
            """;
    public static final String WRONG_PASSWORD = """
            Invalid password. The password you entered does not match the one associated with your account.
            Please double-check your password and try again.
            """;
    public static final String WRONG_USERNAME = """
            Invalid username. The username you entered does not exist in our system.
            Please verify your username and try again.
            """;
    public static final String DUPLICATED_USERNAME = """
            Duplicated username. The username you entered already exists in our system.
            Please use another one and try again.
            """;
}
