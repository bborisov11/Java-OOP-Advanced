package listyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        ListyIterator iterator = new ListyIterator();
        while(!(input = reader.readLine()).equals("END")) {

            String[] inputArgs = input.split(" ");
            String command = inputArgs[0];
            switch (command) {
                case "Create":
                     iterator = new ListyIterator(Arrays.stream(inputArgs).skip(1)
                            .toArray(String[]::new));
                    break;
                case "Move":
                    System.out.println(iterator.move());
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
                case "Print":
                    try {
                        iterator.print();
                    }
                    catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
            }
        }
    }
}
