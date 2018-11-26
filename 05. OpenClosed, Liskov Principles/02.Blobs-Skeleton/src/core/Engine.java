package core;

import interfaces.BlobFactory;
import interfaces.Executable;
import interfaces.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private static final String COMMANDS_PATH = "core.commands.";
    private String[] data;
    private BlobFactory factory;
    private Repository repository;

    public Engine(BlobFactory factory, Repository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String[] input = reader.readLine().split("\\s+");
                if(input[0].equals("drop")) {
                    break;
                }
                 this.interpredCommand(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void interpredCommand(String[] input) {
        this.data = input;
        String currentCommandStr =
                input[0].toUpperCase().charAt(0) + input[0].substring(1) + "Command";
        try {
            Class currentCommandClass = Class.forName(COMMANDS_PATH + currentCommandStr);
            Constructor currentConstructor =
                    currentCommandClass.getDeclaredConstructor(String[].class, BlobFactory.class, Repository.class);
            currentConstructor.setAccessible(true);
            Executable executable = (Executable) currentConstructor.newInstance(this.data, this.factory, this.repository);
            executable.execute();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
