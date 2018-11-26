package еqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int counter = Integer.parseInt(reader.readLine());

        Set<Person> treeSet = new TreeSet<>(new Person());
        Set<Person> hashSet = new HashSet<>();

        for (int i = 0; i < counter; i++) {
            String[] arr = reader.readLine().split(" ");
            treeSet.add(new Person(arr[0],Integer.parseInt(arr[1])));
            hashSet.add(new Person(arr[0],Integer.parseInt(arr[1])));
        }

        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
