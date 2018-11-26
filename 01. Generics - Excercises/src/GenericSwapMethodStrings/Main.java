package GenericSwapMethodStrings;

import GenericSwapMethodIntegers.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Box<String> box = new Box<>();
        for (int i = 0; i < count; i++) {
            String currentString = reader.readLine();
            box.add(currentString);
        }
        int[] swapIndeces = Arrays.stream(reader.readLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();
        box.swap(swapIndeces[0],swapIndeces[1]);
        System.out.println(box.toString());
    }
}
