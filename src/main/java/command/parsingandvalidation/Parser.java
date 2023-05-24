package command.parsingandvalidation;

import command.commands.CommandFactory;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private Parser() {
    }

    public static ParsedCommand parse(String input) {
        List<String> tokens = new ArrayList<>();
        /* remove spaces after and before the equal sign, not to confuse the tokenizer. */
        input = input.replaceAll(" += +", "=");
        tokenize(input, tokens);
        String tag = tokens.remove(0).toLowerCase();
        return new ParsedCommand(CommandFactory.createCommand(tag), tokens, tag);
    }

    private static void tokenize(String input, List<String> tokens) {
        StringBuilder currentToken = new StringBuilder();
        boolean inQuote = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isWhitespace(c)) {
                if (currentToken.length() > 0 && !inQuote) {
                    tokens.add(currentToken.toString());
                    currentToken.setLength(0);
                } else if (inQuote) {
                    currentToken.append(c);
                }
            } else if (c == '"') {
                inQuote = !inQuote;
                currentToken.append(c);
            } else {
                currentToken.append(c);
            }
        }

        /* Add the last token */
        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }
    }
}
