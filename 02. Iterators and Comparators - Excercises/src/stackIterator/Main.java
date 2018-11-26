package stackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        Stack<Integer> stack = new Stack<>();
        while(!(input = reader.readLine()).equals("END")) {
            String[] inputArgs = input.split("[, ]+");
            String command = inputArgs[0];
            switch (command) {
                case "Push":
                    stack.push(Arrays.stream(inputArgs).skip(1)
                            .map(Integer::parseInt).toArray(Integer[]::new));
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    }catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (Integer integer : stack) {
                System.out.println(integer);
            }
        }
    }
}
