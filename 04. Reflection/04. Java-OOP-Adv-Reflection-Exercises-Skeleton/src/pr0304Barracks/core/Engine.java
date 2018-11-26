package pr0304Barracks.core;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Runnable;
import pr0304Barracks.contracts.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	public static final String COMMAND_PATH = "pr0304Barracks.core.commands.";

	private String[] data;
	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpredCommand(data, commandName);
				if ("fight".equals(result)) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpredCommand(String[] data, String commandName) {
		this.data = data;
		String currentCommand = commandName.toUpperCase().charAt(0) + commandName.substring(1) + "Command";
		try {
			Class<?> unitClass = Class.forName(COMMAND_PATH + currentCommand);
			Constructor currentClass = unitClass.getDeclaredConstructor();
			Executable executable = (Executable) currentClass.newInstance();
			this.injection(executable);
			return executable.execute();

		} catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	private <T> void injection(T command) throws IllegalAccessException {
		Field[] commandFields = command.getClass().getDeclaredFields();
		Field[] engineFields = this.getClass().getDeclaredFields();

		for (Field commandField : commandFields) {
			commandField.setAccessible(true);
			if(commandField.isAnnotationPresent(Inject.class)) {
				for (Field engineField : engineFields) {
					if(commandField.getType().getSimpleName().equals(engineField.getType().getSimpleName()) &&
							commandField.getType().equals(engineField.getType())) {
						engineField.setAccessible(true);
						commandField.set(command, engineField.get(this));
					}
				}
			}
		}
	}
}
