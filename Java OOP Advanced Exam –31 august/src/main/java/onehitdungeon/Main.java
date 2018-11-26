package onehitdungeon;

import onehitdungeon.core.HeroTrainerImpl;
import onehitdungeon.interfaces.DungeonManager;
import onehitdungeon.interfaces.HeroTrainer;
import onehitdungeon.interfaces.InputReader;
import onehitdungeon.interfaces.OutputWriter;
import onehitdungeon.io.ConsoleReader;
import onehitdungeon.io.ConsoleWriter;
import onehitdungeon.manager.DungeonManagerImpl;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        HeroTrainer heroTrainer = new HeroTrainerImpl();
        DungeonManager manager = new DungeonManagerImpl(heroTrainer);

        Engine engine = new Engine(reader,writer,manager);
        engine.run();
    }
}
