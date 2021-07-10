package controller;

import java.util.HashMap;
import java.util.Map;

import controllerCommandMethods.GoToMainPage;


import controllerCommandMethods.UnknownCommand;
import controllerCommandMethods.CommandAfterRedirectToInPlay;
import controllerCommandMethods.CommandInPlaing;
import controllerCommandMethods.CommandToPlay;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
	
	
		commands.put(CommandName.GO_TO_MAIN_PAGE, new GoToMainPage());
		commands.put(CommandName.UNKNOWN_COMMAND, new UnknownCommand());
		commands.put(CommandName.COMMAND_TO_PLAY, new CommandToPlay());
		commands.put(CommandName.COMMAND_IN_PLAYING, new CommandInPlaing());
		commands.put(CommandName.COMMAND_AFTER_REDIRECT_TO_INPLAING, new CommandAfterRedirectToInPlay());
	}
	
	public Command findCommand(String name) {
		if (name == null) {
			name = CommandName.UNKNOWN_COMMAND.toString();
		}
		
		CommandName commandName;
		try {
		    commandName = CommandName.valueOf(name.toUpperCase());
		}catch(IllegalArgumentException e) {
			// logging
			commandName = CommandName.UNKNOWN_COMMAND;	
		}
		
		Command command = commands.get(commandName);
		return command;
	}

}
