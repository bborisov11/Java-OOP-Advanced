package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class Main {
	public static void main(String[] args) throws IOException {

		Class richSoilLand = RichSoilLand.class;

		Field[] fields = richSoilLand.getDeclaredFields();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String input;

		while (!(input = reader.readLine()).equals("HARVEST")) {
			if (!input.equals("all")) {
				for (int i = 0; i < fields.length; i++) {
					if (fields[i].toString().split(" ")[0].equals(input)) {
						System.out.println(String.format("%s %s %s",
								input, fields[i].getType().getSimpleName(), fields[i].getName()));
					}
				}
			} else {
				for (int j = 0; j < fields.length; j++) {
					System.out.println(String.format("%s %s %s",
							fields[j].toString().split(" ")[0], fields[j].getType().getSimpleName()
							, fields[j].getName()));
				}
			}
		}

	}

}
