package froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!(input = reader.readLine()).equals("END")) {

            Integer[] inputArgs = Arrays.stream(input.split("[ ,]+"))
                    .map(Integer::parseInt).toArray(Integer[]::new);
            Lake lake = new Lake(inputArgs);
            StringBuilder builder = new StringBuilder();
            for (Integer integer : lake) {
                if(integer != null) {
                    builder.append(integer).append(", ");
                }
            }
            builder.replace(builder.length() - 2, builder.length(),"");
            System.out.println(builder.toString());
        }


    }
}
