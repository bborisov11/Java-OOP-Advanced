package GenericCountMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Box<Double> box = new Box<>();
        for (int i = 0; i < count; i++) {
            double currentInt = Double.parseDouble(reader.readLine());
            box.add(currentInt);
        }
        double repeatingString = Double.parseDouble(reader.readLine());


        System.out.println(box.compareTo(repeatingString));
    }
}
