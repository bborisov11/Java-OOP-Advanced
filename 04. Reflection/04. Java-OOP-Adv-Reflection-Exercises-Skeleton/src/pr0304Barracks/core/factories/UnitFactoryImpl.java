package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		{
			Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor constr = clazz.getDeclaredConstructor();
			constr.setAccessible(true);
			Object currentClass = constr.newInstance();
			return (Unit) currentClass;
		}
	}
}
