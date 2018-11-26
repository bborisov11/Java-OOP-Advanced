package comparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> persons = new ArrayList<>();
        String input;

        int numberOfEqualPeople = 1;
        int numberOfNotEqualPeople = 0;
        int totalNumberOfPeople = 0;

        while (!(input = reader.readLine()).equals("END")) {
            String[] inputArgs = input.split(" ");
            persons.add(new Person(inputArgs[0],Integer.parseInt(inputArgs[1]),inputArgs[2]));
        }
        int personsIndex = Integer.parseInt(reader.readLine());

        for (Person person : persons) {
            if(person != persons.get(personsIndex - 1)) {
                    if(persons.get(personsIndex - 1).compareTo(person) == 0) {
                        numberOfEqualPeople++;
                    }
                    else {
                        numberOfNotEqualPeople++;
                    }
            }
            totalNumberOfPeople++;
        }
        if(numberOfEqualPeople > 1) {
            System.out.println(numberOfEqualPeople + " " + numberOfNotEqualPeople + " " + totalNumberOfPeople);
        }
        else {
            System.out.println("No matches");
        }
    }
}
