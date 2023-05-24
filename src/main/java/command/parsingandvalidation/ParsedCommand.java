package command.parsingandvalidation;

import command.commands.Command;

import java.util.List;

public record ParsedCommand(Command command, List<String> args, String tag) {
}
