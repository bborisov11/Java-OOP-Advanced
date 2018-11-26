package panzer.engine;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Engine {
    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public Engine(InputReader reader, OutputWriter outputWriter, Manager manager) {
        this.reader = reader;
        this.writer = outputWriter;
        this.manager = manager;
    }

    public void run() {
        while (true) {
            String command = interpretCommands();

            if ("Terminate".equals(command)) {
                break;
            }

            this.writer.println(command);
        }
    }

    private String interpretCommands() {
        String line = this.reader.readLine();

            String[] lineTokens = line.split("\\s+");

            switch (lineTokens[0]) {
                case "Vehicle":
                   return this.manager.addVehicle(Arrays.stream(lineTokens)
                            .skip(1).collect(Collectors.toList()));
                case "Part":
                    return this.manager.addPart(Arrays.stream(lineTokens)
                            .skip(1).collect(Collectors.toList()));
                case "Battle":
                    return this.manager.battle(Arrays.stream(lineTokens)
                            .skip(1).collect(Collectors.toList()));
                case "Inspect":
                    return this.manager.inspect(Arrays.stream(lineTokens)
                            .skip(1).collect(Collectors.toList()));
                case "Terminate":
                    this.writer.println(this.manager.terminate(Arrays.stream(lineTokens)
                            .skip(1).collect(Collectors.toList())));
                    return "Terminate";
            }
            return "Wrong input";
        }
    }
