package app;

import app.Engine.EngineImpl;
import app.contracts.*;
import app.core.BattlefieldImplementation;
import app.factory.ActionFactoryImpl;
import app.factory.TargetableFactoryImpl;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        TargetableFactory targetableFactory = new TargetableFactoryImpl();
        ActionFactory actionFactory = new ActionFactoryImpl();
        Battlefield battlefield = new BattlefieldImplementation(writer, targetableFactory, actionFactory);
        Engine engine = new EngineImpl(reader, writer, battlefield);
        engine.run();
    }
}
