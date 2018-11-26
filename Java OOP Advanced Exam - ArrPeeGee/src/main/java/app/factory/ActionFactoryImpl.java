package app.factory;

import app.contracts.Action;
import app.contracts.ActionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ActionFactoryImpl implements ActionFactory {

    private static final String ACTION_PATH = "app.models.actions.";

    @Override
    public Action create(String actionName, String... participantNames)
            throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> currentAction = Class.forName(ACTION_PATH + actionName);
        Constructor actionConstructor = currentAction.getDeclaredConstructor();
        return (Action) actionConstructor.newInstance();

    }
}
