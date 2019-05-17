package by.it.academy.taxis.command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
	static CommandFactory commandFactory;

	private CommandFactory() {
	}

	public static CommandFactory getInstance() {
		if (commandFactory == null) {
			synchronized (CommandFactory.class) {

				commandFactory = new CommandFactory();
			}
		}
		return commandFactory;
	}

	static Map<String, Command> commandMap = new HashMap<String, Command>();
	static {
		commandMap.put("addResult", new AddCommand());
		commandMap.put("home", new HomePageCommand());
		commandMap.put("sort", new SortCommand());
		commandMap.put("findCarResult", new FindCarCommand());
		commandMap.put("delete", new DeleteCommand());
		commandMap.put("editResult", new UpdateResultCommand());
		commandMap.put("deleteResult", new DeleteResultCommand());
		commandMap.put("settings", new SettingsCommand());
		commandMap.put("giveAdmin", new GiveAdminCommand());
		commandMap.put("costOfTravel", new CostOfTravelCommand());
		commandMap.put("costOfTripResult", new CostOfTripResultCommand());
		commandMap.put("add", new ForwardCommand());
		commandMap.put("findCar", new ForwardCommand());
		commandMap.put("edit", new EditPageCommand());
	}

	public Command getCommand(String action) {
		return commandMap.get(action);

	}

}
