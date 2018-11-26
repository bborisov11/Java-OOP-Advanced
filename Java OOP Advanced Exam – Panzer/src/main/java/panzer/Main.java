package panzer;

import panzer.contracts.BattleOperator;
import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.core.PanzerBattleOperator;
import panzer.engine.Engine;
import panzer.io.ConsoleReader;
import panzer.io.ConsoleWriter;
import panzer.manager.ManagerImpl;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        BattleOperator battleOperator = new PanzerBattleOperator();
        Manager manager = new ManagerImpl(battleOperator);
        Engine engine = new Engine(reader, writer, manager);
        engine.run();
    }
}
