package utilities;

public class StringUtils {
    public static String titleCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        String[] words = input.split("\\s+");

        for (String word : words) {
            if (word.length() > 0) {
                char firstChar = Character.toUpperCase(word.charAt(0));
                String restOfWord = word.substring(1).toLowerCase();
                result.append(firstChar).append(restOfWord).append(" ");
            }
        }

        return result.toString().trim();
    }
    public static String removeQuotes(String quoted) {
        if (!quoted.contains("\""))
            return quoted;
        return quoted.substring(1, quoted.length() - 1);
    }
}
