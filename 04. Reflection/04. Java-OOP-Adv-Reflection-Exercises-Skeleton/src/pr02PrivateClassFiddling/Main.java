package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String input;

		Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;
		Constructor constr = blackBoxIntClass.getDeclaredConstructor();
		constr.setAccessible(true);
		BlackBoxInt currentBlackBox = (BlackBoxInt) constr.newInstance();

		while (!(input = reader.readLine()).equals("END")) {
			String[] arg = input.split("_");

			switch (arg[0]) {
				case "add":
					Method addMethod = blackBoxIntClass
							.getDeclaredMethod("add", int.class);
					addMethod.setAccessible(true);
					addMethod.invoke(currentBlackBox, Integer.parseInt(arg[1]));
					Field field = blackBoxIntClass.getDeclaredField("innerValue");
					field.setAccessible(true);
					System.out.println(field.get(currentBlackBox));
					break;
				case "subtract":
					Method subtractMethod = blackBoxIntClass
							.getDeclaredMethod("subtract", int.class);
					subtractMethod.setAccessible(true);
					subtractMethod.invoke(currentBlackBox, Integer.parseInt(arg[1]));
					field = blackBoxIntClass.getDeclaredField("innerValue");
					field.setAccessible(true);
					System.out.println(field.get(currentBlackBox));
					break;
				case "divide":
					Method divideMethod = blackBoxIntClass
							.getDeclaredMethod("divide", int.class);
					divideMethod.setAccessible(true);
					divideMethod.invoke(currentBlackBox, Integer.parseInt(arg[1]));
					field = blackBoxIntClass.getDeclaredField("innerValue");
					field.setAccessible(true);
					System.out.println(field.get(currentBlackBox));
					break;
				case "multiply":
					Method multiplyMethod = blackBoxIntClass
							.getDeclaredMethod("multiply", int.class);
					multiplyMethod.setAccessible(true);
					multiplyMethod.invoke(currentBlackBox, Integer.parseInt(arg[1]));
					field = blackBoxIntClass.getDeclaredField("innerValue");
					field.setAccessible(true);
					System.out.println(field.get(currentBlackBox));
					break;
				case "rightShift":
					Method rightShiftMethod = blackBoxIntClass
							.getDeclaredMethod("rightShift", int.class);
					rightShiftMethod.setAccessible(true);
					rightShiftMethod.invoke(currentBlackBox, Integer.parseInt(arg[1]));
					field = blackBoxIntClass.getDeclaredField("innerValue");
					field.setAccessible(true);
					System.out.println(field.get(currentBlackBox));
					break;
				case "leftShift":
					Method leftShiftMethod = blackBoxIntClass
							.getDeclaredMethod("leftShift", int.class);
					leftShiftMethod.setAccessible(true);
					leftShiftMethod.invoke(currentBlackBox, Integer.parseInt(arg[1]));
					field = blackBoxIntClass.getDeclaredField("innerValue");
					field.setAccessible(true);
					System.out.println(field.get(currentBlackBox));
					break;
			}
		}
	}
}
