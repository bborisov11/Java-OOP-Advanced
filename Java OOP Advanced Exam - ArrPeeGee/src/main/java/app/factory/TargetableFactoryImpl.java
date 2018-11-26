package app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TargetableFactoryImpl implements TargetableFactory {

    private static final String CURRENT_PARTICIPANT_PATH = "app.models.participants.";

    @Override
    public Targetable create(String name, String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> currentParticipant = Class.forName(CURRENT_PARTICIPANT_PATH + className);
        Constructor constructor = currentParticipant.getDeclaredConstructor();
        constructor.setAccessible(true);
        Targetable targetable = (Targetable) constructor.newInstance();
        targetable.setName(name);
        return targetable;
    }
}
