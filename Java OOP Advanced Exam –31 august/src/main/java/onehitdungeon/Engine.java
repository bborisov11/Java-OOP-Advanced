package onehitdungeon;

import onehitdungeon.interfaces.DungeonManager;
import onehitdungeon.interfaces.InputReader;
import onehitdungeon.interfaces.OutputWriter;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Engine {
    private InputReader reader;
    private OutputWriter writer;
    private DungeonManager manager;

    public Engine(InputReader reader, OutputWriter writer, DungeonManager manager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }

    public void run() {
        while (true) {
            String command = interpretCommands();

            if ("Quit".equals(command)) {
                break;
            }

            this.writer.println(command);
        }
    }

    private String interpretCommands() {
        String line = this.reader.readLine();

        String[] lineTokens = line.split("\\s+");

        switch (lineTokens[0]) {
            case "Hero":
               return this.manager.hero(Arrays.stream(lineTokens).skip(1).collect(Collectors.toList()));
            case "Select":
                return this.manager.select(Arrays.stream(lineTokens).skip(1).collect(Collectors.toList()));
            case "Status":
                return this.manager.status(Arrays.stream(lineTokens).skip(1).collect(Collectors.toList()));
            case "Fight":
                return this.manager.fight(Arrays.stream(lineTokens).skip(1).collect(Collectors.toList()));
            case "Advance":
                return this.manager.advance(Arrays.stream(lineTokens).skip(1).collect(Collectors.toList()));
            case "Train":
                return this.manager.train(Arrays.stream(lineTokens).skip(1).collect(Collectors.toList()));
            case "Quit":
                System.out.println(this.manager.quit(Arrays.stream(lineTokens).skip(1).collect(Collectors.toList())));
                return "Quit";
        }
        return null;
    }
}
