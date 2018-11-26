package strategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int counter = Integer.parseInt(reader.readLine());

        Set<Person> comparedByNameLength = new TreeSet<>(Comparators.nameLengthAndLetter);
        Set<Person> comparedByAge = new TreeSet<>(Comparators.ageComparator);

        for (int i = 0; i < counter; i++) {
            String[] arr = reader.readLine().split(" ");
            comparedByNameLength.add(new Person(arr[0],Integer.parseInt(arr[1])));
            comparedByAge.add(new Person(arr[0],Integer.parseInt(arr[1])));
        }

        for (Person person : comparedByNameLength){
            System.out.println(person.getName() + " " + person.getAge());
        }
        for (Person person : comparedByAge){
            System.out.println(person.getName() + " " + person.getAge());
        }
    }
}
